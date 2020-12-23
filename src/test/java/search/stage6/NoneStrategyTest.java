package search.stage6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoneStrategyTest {

    @Test
    void shouldFindOnePerson() {
        Strategy strategy = new NoneStrategy();
        strategy.setAllPeople(List.of(
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com",
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Myrtle Medina",
                "Erick Burgess"));
        strategy.setQueries(List.of(
                "djo@gmail.com",
                "ERICK"));
        List<String> expected = List.of(
                "Katie Jacobs",
                "Myrtle Medina",
                "Rene Webb webb@gmail.com");
        strategy.buildIndecies();
        List<String> actual = strategy.execute();
        assertEquals(expected, actual);
    }
}