import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHasMapTest {
    public static void main(String[] args) {
        Map<String , String> accessOrderFalse = new LinkedHashMap<>();
        accessOrderFalse.put("1", "1");
        accessOrderFalse.put("2", "2");
        accessOrderFalse.put("3", "3");
        accessOrderFalse.put("4", "4");
        System.out.println("accessOrderFalse:" + accessOrderFalse.toString());

        Map<String, String> accessOrderTrue = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderTrue.put("1", "1");
        accessOrderTrue.put("2", "2");
        accessOrderTrue.put("3", "3");
        accessOrderTrue.put("4", "4");
        accessOrderTrue.get("2");
        accessOrderTrue.get("3");
        System.out.println("accessOrderTrue:" + accessOrderTrue.toString());
    }
}
