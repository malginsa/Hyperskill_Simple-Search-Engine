package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {

        List<String> allPeople = inputPersons();
        int menuItem = getMenuItem();
        while (menuItem != 0) {
            switch (menuItem) {
                case 1:
                    findPerson(allPeople);
                    break;
                case 2:
                    print(allPeople);
                    break;
                case 0:
                    break;
            }
            menuItem = getMenuItem();
        }
        System.out.println("\nBye!");
    }

    private static void print(List<String> text) {
        System.out.println("\n=== List of people ===");
        text.forEach(System.out::println);
    }

    private static void findPerson(List<String> allPeople) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");
        List<String> results = searchWord(allPeople, scanner.nextLine());
        results.forEach(System.out::println);
    }

    private static int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            String line = scanner.nextLine().trim();
            if ("1".equals(line) || "2".equals(line) || "0".equals(line))
                return Integer.parseInt(line);
            else
                System.out.println("\nIncorrect option! Try again.");
        }
    }

    private static ArrayList<String> inputPersons() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            text.add(scanner.nextLine());
        }
        return text;
    }

    protected static List<String> searchWord(List<String> text, String wordToSearch) {
        List<String> result = new ArrayList<>();
        String word = wordToSearch.toLowerCase();
        for (String string : text) {
            if (string.toLowerCase().contains(word))
                result.add(string);
        }
        if (result.isEmpty())
            result.add("No matching people found.");
        return result;
    }
}
