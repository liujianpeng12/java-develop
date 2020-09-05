import java.util.Collections;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        int hash = hash("123");
        System.out.println(hash);
        System.out.println((10 - 1) & hash);


        Collections.synchronizedMap(new HashMap<>()).put("1", "a");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
