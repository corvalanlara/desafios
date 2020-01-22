package sexto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Counter<T> {
    final Map<T, Integer> counts = new HashMap<>();

    public void add(T t) {
        counts.merge(t, 1, Integer::sum);
    }

    public int count(T t) {
        return counts.getOrDefault(t, 0);
    }
    
    public int min() {
    	return Collections.min(counts.values());
    }
    
    public int max() {
    	return Collections.max(counts.values());
    }
   
    public Set<T> getKeysByValue(int value) {
        return counts.entrySet()
                  .stream()
                  .filter(entry -> Objects.equals(entry.getValue(), value))
                  .map(Map.Entry::getKey).collect(Collectors.toSet());
    }
    
    public Integer promedio() {
    	return counts.values().stream().reduce(0, (a, b) -> a + b) / counts.size();
    }
 
}
