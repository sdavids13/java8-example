import java.util.*;

public class Java7Example implements CollectionExample, MathExample {


    public List<String> lowerCase(List<String> toLower) {
        List<String> lowerCased = new ArrayList<>();
        for(String input : toLower) {
            if(input != null) {
                lowerCased.add(input.toLowerCase());
            }
        }

        return lowerCased;
    }

    @Override
    public Map<String, Long> wordCount(List<String> words) {
        Map<String, Long> wordCount = new HashMap<>();
        for(String word : words) {
            String key = word.toLowerCase();
            if(!wordCount.containsKey(key)) {
                wordCount.put(key, 0L);
            }
            wordCount.put(key, wordCount.get(key) + 1);
        }

        return wordCount;
    }

    @Override
    public void addValue(Map<String, List<String>> map, String key, String value) {
        List<String> entry = map.get(key);
        if(entry == null) {
            entry = new ArrayList<>();
            map.put(key, entry);
        }

        entry.add(value);
    }

    @Override
    public Comparator<String> getStringLengthComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
    }

    public int sum(int... intsToSum) {
        int sum = 0;
        for(int input : intsToSum) {
            sum += input;
        }

        return sum;
    }

    public double average(int... intsToAverage) {
        return sum(intsToAverage) / (double) intsToAverage.length;
    }

    public int factorial(int baseNumber) {
        int factorial = 1;
        for(int i = 1; i <= baseNumber; i++) {
            factorial *= i;
        }

        return factorial;
    }

    @Override
    public List<Integer> gatherPrimes(int maxPrime) {
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= maxPrime; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

}
