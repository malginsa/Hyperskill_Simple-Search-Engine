package search;

//import org.junit.Assert;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AnyStrategyTest {

    @Test
    void shouldFindFourPerson() {
        Strategy strategy = new AnyStrategy();
        strategy.setAllPersons(List.of(
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com",
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Myrtle Medina",
                "Erick Burgess"));
        strategy.setQueries(List.of(
                "Erick",
                "Dwight",
                "webb@gmail.com"));
        Set<String> expected = Set.of(
                "Erick Harrington harrington@gmail.com",
                "Erick Burgess",
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com");
        strategy.buildIndecies();
        Set<String> actual = new HashSet<String>(strategy.execute());
        Assert.assertEquals(expected, actual);
    }

    @Test
    void shouldFindThreePerson() {
        Strategy strategy = new AnyStrategy();
        strategy.setAllPersons(List.of(
                "Dwight Joseph djo@gmail.com",
                "Rene Webb webb@gmail.com",
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Myrtle Medina",
                "Erick Burgess"));
        strategy.setQueries(List.of(
                "Katie",
                "Erick",
                "QQQ"));
        List<String> expected = List.of(
                "Katie Jacobs",
                "Erick Harrington harrington@gmail.com",
                "Erick Burgess");
        strategy.buildIndecies();
        List<String> actual = strategy.execute();
        Assert.assertEquals(expected, actual);
    }
}