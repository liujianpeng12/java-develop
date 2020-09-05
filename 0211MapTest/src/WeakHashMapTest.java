import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        Map weakHashMap = new WeakHashMap();

        for (int i = 0; i < 5; i++) {
            weakHashMap.put("key-" + i, "value-" + i);
        }

        System.out.println("数组长度："+weakHashMap.size() + "，输出结果：" + weakHashMap);

        //主动触发一次GC
        System.gc();

        System.out.println("数组长度："+weakHashMap.size() + "，输出结果：" + weakHashMap);
    }
}
