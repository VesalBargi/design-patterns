import java.util.HashMap;
import java.util.Iterator;

public class HashMapAdapter implements Iterable<String> {
    private HashMap<String, String> map;

    public HashMapAdapter(HashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }
}
