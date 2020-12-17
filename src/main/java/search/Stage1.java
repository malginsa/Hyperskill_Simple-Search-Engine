package search;

import java.util.Scanner;

public class Stage1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String wordToSearch = scanner.nextLine();
        searchWord(text, wordToSearch);
    }

    protected static void searchWord(String text, String wordToSearch) {
        String result = "Not found";
        String[] words = text.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(wordToSearch))
                result = String.valueOf(i + 1);
        }
        System.out.println(result);
        return;
    }
}
