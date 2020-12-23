package search;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NoneStrategyTest {

    @Test
    void shouldFindOnePerson() {
        Strategy strategy = new NoneStrategy();
        strategy.setAllPersons(List.of(
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com",
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Myrtle Medina",
                "Erick Burgess"));
        strategy.setQueries(List.of(
                "djo@gmail.com",
                "ERICK"));
        Set<String> expected = Set.of(
                "Katie Jacobs",
                "Myrtle Medina",
                "Rene Webb webb@gmail.com");
        strategy.buildIndecies();
        Set<String> actual = new HashSet<String>(strategy.execute());
        assertEquals(expected, actual);
    }
}