package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SimpleSearchEngineTest {

    private static final PrintStream defaultSystemOut = System.out;

    @Test
    public void shouldFoundWord() {
        String text = "first second third fourth";
        String word = "third";
        String result = "3";
        assertPrinted(text, word, result);
    }

    @Test
    public void shouldNotFoundWord() {
        String text = "cat dog and mouse";
        String word = "elephant";
        String result = "Not found";
        assertPrinted(text, word, result);
    }

    private void assertPrinted(String text, String word, String result) {
        ByteArrayOutputStream tmpOutputStream = createTmpOutputStream();
        SimpleSearchEngine.searchWord(text, word);
        assertEquals(result, tmpOutputStream.toString().trim());
        System.setOut(defaultSystemOut);
    }

    private ByteArrayOutputStream createTmpOutputStream() {
        ByteArrayOutputStream tmpOutputStream = (new ByteArrayOutputStream());
        System.setOut(new PrintStream(tmpOutputStream));
        return tmpOutputStream;
    }
}
