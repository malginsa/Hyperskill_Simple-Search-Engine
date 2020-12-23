package search;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllStrategy extends Strategy {
    @Override
    List<String> execute() {

        List<List<Integer>> multilistOfIndices = getQueries().stream()
                .map(String::toLowerCase)
                .map(query -> getIndicees(query))
                .collect(Collectors.toList());

        return intersectionOfLists(multilistOfIndices)
                .stream()
                .map(index -> getAllPersons().get(index))
                .collect(Collectors.toList());
    }

    protected static List<Integer> intersectionOfLists(List<List<Integer>> multiCollection) {
        return multiCollection.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == multiCollection.size())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
