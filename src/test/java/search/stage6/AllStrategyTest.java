package search.stage6;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static search.stage6.AllStrategy.intersectionOfLists;

class AllStrategyTest {

    @Test
    void shouldFindOnePerson() {
        Strategy strategy = new AllStrategy();
        strategy.setAllPeople(List.of(
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com",
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Myrtle Medina",
                "Erick Burgess"));
        strategy.setQueries(List.of(
                "Harrington",
                "Erick"));
        List<String> expected = List.of(
                "Erick Harrington harrington@gmail.com");
        strategy.buildIndecies();
        List<String> actual = strategy.execute();
        assertEquals(expected, actual);
    }

    @Test
    public void intersectionOfListsTest() {
        List<Integer> actual = intersectionOfLists(List.of(
                List.of(1, 2, 3),
                List.of(2, 3, 4)));
        List<Integer> expected = List.of(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void emptyIntersectionTest() {
        List<Integer> actual = intersectionOfLists(List.of(
                List.of(1, 2),
                List.of(3, 4)));
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }
}