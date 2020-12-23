package search;

import java.util.List;
import java.util.stream.Collectors;

public class AnyStrategy extends Strategy {
    @Override
    List<String> execute() {
        return getQueries().stream()
                .map(query -> getIndicees(query))
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .map(index -> getAllPersons().get(index))
                .collect(Collectors.toList());
    }
}
