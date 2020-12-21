package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * "--data src/main/resources/text.txt" should be specified as a parameter
 */
public class Stage5 {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> allPeople = inputPersonsFromFile(getInputFileName(args));
        Map<String, List<Integer>> index = createInvertedIndex(allPeople);
        int menuItem = getMenuItem();
        while (menuItem != 0) {
            switch (menuItem) {
                case 1:
                    findPerson(allPeople, index);
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

    private static Map<String, List<Integer>> createInvertedIndex(List<String> allPeople) {
        Map<String, List<Integer>> result = new HashMap<>();
        for (int lineNumber = 0; lineNumber < allPeople.size(); lineNumber++) {
            for (String word : allPeople.get(lineNumber).toLowerCase().split(" ")) {
                updateMap(result, word, lineNumber);
            }
        }
        return result;
    }

    private static void updateMap(Map<String, List<Integer>> map, String word, int lineNumber) {
        List<Integer> value;
        if (map.containsKey(word)) {
            value = map.get(word);
        } else {
            value = new ArrayList<>();
            map.put(word, value);
        }
        value.add(lineNumber);
    }

    private static void print(List<String> text) {
        System.out.println("\n=== List of people ===");
        text.forEach(System.out::println);
    }

    private static void findPerson(List<String> allPeople, Map<String, List<Integer>> index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");
//        List<String> results = searchWord(allPeople, scanner.nextLine());
        List<String> results = searchWord(allPeople, index.get(scanner.nextLine().toLowerCase()));
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

    private static String getInputFileName(String[] args) {
        validate(args);
        int i = 0;
        while (!args[i].equals("--data") && i < args.length - 1)
            i++;
        if (i < args.length - 1)
            return args[i + 1];
        else
            throw new IllegalArgumentException("can't find fileName among parameters to the application");
    }

    private static void validate(String[] args) {
        if (args == null || args.length < 2)
            throw new IllegalArgumentException("--data <inputFileName> should be among parameters");
    }

    private static List<String> inputPersonsFromFile(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName))
                .lines()
                .collect(Collectors.toList());
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

    protected static List<String> searchWord(List<String> text, List<Integer> indices) {
        if (indices == null || indices.isEmpty()) return Arrays.asList("No matching people found.\n");
        return indices.stream().map(i -> text.get(i)).collect(Collectors.toList());
    }
}
