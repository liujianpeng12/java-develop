import java.util.Collections;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("123".hashCode());
        int hash = hash("61");
        System.out.println(hash);
        System.out.println((10 - 1) & hash);

        System.out.println(1 << 4);

        Collections.synchronizedMap(new HashMap<>()).put("1", "a");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
