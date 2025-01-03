import java.util.Arrays;
import java.util.Iterator;

public class StringArrayAdapter implements Iterable<String> {
    private String[] array;

    public StringArrayAdapter(String[] array) {
        this.array = array;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(array).iterator();
    }
}
