package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public abstract class Strategy {

     private List<String> allPersons;
     private List<String> queries;
     private Map<String, List<Integer>> indices;

     abstract List<String> execute();

     public void buildIndecies() {
          Map<String, List<Integer>> indecies = new HashMap<>();
          for (int lineNumber = 0; lineNumber < getAllPersons().size(); lineNumber++) {
               for (String word : getAllPersons().get(lineNumber).toLowerCase().split(" ")) {
                    updateMap(indecies, word, lineNumber);
               }
          }
          setIndices(indecies);
     }

     public List<Integer> getIndicees(String query) {
          return getIndices().getOrDefault(query, emptyList());
     }

     private static void updateMap(Map<String, List<Integer>> map, String word, int lineNumber) {
          List<Integer> value;
          if (map.containsKey(word)) {
               value = map.get(word);
          } else {
               value = new ArrayList<>();
               map.put(word, value);
          }
          value.add(lineNumber);
     }

     protected List<String> getAllPersons() {
          return allPersons;
     }

     protected List<String> getQueries() {
          return queries;
     }

     protected Map<String, List<Integer>> getIndices() {
          return indices;
     }

     public void setAllPersons(List<String> allPersons) {
          this.allPersons = allPersons;
     }

     public void setQueries(List<String> queries) {
          this.queries = queries.stream()
                  .map(String::toLowerCase)
                  .collect(Collectors.toList());
     }

     public void setIndices(Map<String, List<Integer>> indices) {
          this.indices = indices;
     }
}
