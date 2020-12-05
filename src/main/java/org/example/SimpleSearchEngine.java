package org.example;

public class SimpleSearchEngine {

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
