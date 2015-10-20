import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface CollectionExample {

    /**
     * @return New collection with all values lowercased, drop any null values.
     */
    List<String> lowerCase(List<String> toLower);

    /**
     * @return Key: Normalized word to lowercase, Value: Number of word occurrences in the collection of words
     */
    Map<String, Long> wordCount(List<String> words);

    /**
     * Adds a value to the key's list of values, if no value is available a new value list is created.
     */
    void addValue(Map<String, List<String>> map, String key, String value);

    /**
     * @return a Comparator which orders from smallest strings to largest
     */
    Comparator<String> getStringLengthComparator();
}
