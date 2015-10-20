import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class CollectionExampleTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<MathExample[]> data() {
        return Arrays.asList(new MathExample[][] {
            {new Java7Example()}, {new Java8Example()}
        });
    }

    @Parameterized.Parameter
    public CollectionExample implementation;

    @Test
    public void lowercaseCollection() {
        assertThat(implementation.lowerCase(Arrays.asList((String) null)), empty());
        assertThat(implementation.lowerCase(Arrays.asList("A", "b", null, "C")), contains("a", "b", "c"));
    }

    @Test
    public void wordCount() {
        assertThat(implementation.wordCount(Arrays.asList("A", "b", "b", "C", "A", "A", "c")), allOf(
                hasEntry("a", 3L), hasEntry("b", 2L), hasEntry("c", 2L)
        ));
    }

    @Test
    public void addValue() {
        Map<String, List<String>> map = new HashMap<>();
        implementation.addValue(map, "foo", "foo");
        implementation.addValue(map, "foo", "bar");
        implementation.addValue(map, "foo", "baz");
        implementation.addValue(map, "bar", "baz");

        assertThat(map, allOf(
                hasEntry(is("foo"), hasItems("foo", "bar", "baz")),
                hasEntry(is("bar"), hasItems("baz"))
        ));
    }

    @Test
    public void stringLengthComparator() {
        Set<String> sortedSet = new TreeSet<>(implementation.getStringLengthComparator());
        Stream.of("22", "333", "1", "4444", "").forEach(sortedSet::add);

        assertThat(sortedSet, contains("", "1", "22", "333", "4444"));
    }

}
