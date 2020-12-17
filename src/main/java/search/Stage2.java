package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        ArrayList<String> text = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            text.add(scanner.nextLine());
        }

        System.out.println("\nEnter the number of search queries:");
        int numberOfQueries = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfQueries; i++) {
            System.out.println("\nEnter data to search people:");
            String query = scanner.nextLine();
            List<String> result = searchWord(text, query);
            if (result == null || result.isEmpty()) {
                System.out.println("No matching people found.");
            } else {
                System.out.println("\nFound people:");
                for (String s : result) {
                    System.out.println(s);
                }
            }
        }
    }

    protected static List<String> searchWord(List<String> text, String wordToSearch) {
        List<String> result = new ArrayList<>();
        String word = wordToSearch.toLowerCase();
        for (String string : text) {
            if (string.toLowerCase().contains(word))
                result.add(string);
        }
        return result;
    }
}
