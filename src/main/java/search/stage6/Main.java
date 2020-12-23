package search.stage6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * "--data src/main/resources/text.txt" should be specified as a parameter
 */
public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        Main main = new Main();
        List<String> allPeople = inputPersonsFromFile(getInputFileName(args));

        int menuItem = main.getMenuItem();
        while (menuItem != 0) {
            switch (menuItem) {
                case 1:
                    Context context = main.inputStrategy();
                    List<String> queries = main.inputContext();
                    print(context.invoke(allPeople, queries), "");
                    break;
                case 2:
                    print(allPeople, "\n=== List of people ===\n");
                    break;
                case 0:
                    break;
            }
            menuItem = main.getMenuItem();
        }
        System.out.println("\nBye!");
    }

    private static void print(List<String> people, String header) {
        System.out.println(header);
        people.forEach(System.out::println);
    }

    private List<String> inputContext() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        List<String> queries = Arrays.asList(scanner.nextLine().split(" "));
        return queries;
    }

    private Context inputStrategy() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        return Context.createStrategy(scanner.nextLine());
    }

    private int getMenuItem() {
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
}
