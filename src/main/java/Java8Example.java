import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Example implements CollectionExample, MathExample {

    @Override
    public List<String> lowerCase(List<String> toLower) {
        return toLower.stream().filter(input -> input != null).map(String::toLowerCase).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> wordCount(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    @Override
    public void addValue(Map<String, List<String>> map, String key, String value) {
        List<String> entry = map.getOrDefault(key, new ArrayList<>());
        entry.add(value);
        map.putIfAbsent(key, entry);
    }

    @Override
    public Comparator<String> getStringLengthComparator() {
        return (o1, o2) -> o1.length() - o2.length();
    }

    @Override
    public int sum(int... intsToSum) {
        return IntStream.of(intsToSum).sum();
    }

    @Override
    public double average(int... intsToSum) {
        return IntStream.of(intsToSum).average().getAsDouble();
    }

    @Override
    public int factorial(int baseNumber) {
        return IntStream.rangeClosed(1, baseNumber).reduce((left, right) -> left * right).orElse(1);
    }

    public List<Integer> gatherPrimes(int maxPrime) {
        return IntStream.rangeClosed(2, maxPrime).parallel().filter(this::isPrime).boxed().collect(Collectors.toList());
    }

}
