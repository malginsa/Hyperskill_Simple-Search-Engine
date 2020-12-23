package search.stage6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NoneStrategy extends Strategy {
    @Override
    List<String> execute() {
        List<Integer> unitedIndices = getQueries().stream()
                .map(query -> getIndicees(query))
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        List<Integer> allIndices = IntStream.range(0, getAllPeople().size()).boxed().collect(Collectors.toList());
        allIndices.removeAll(unitedIndices);
        return allIndices.stream()
                .map(index -> getAllPeople().get(index))
                .collect(Collectors.toList());
    }
}
