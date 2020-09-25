import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap内部维护了一个双向链表，能保证元素按插入的顺序访问，也能以访问顺序访问，可以用来实现LRU缓存策略。
 * LinkedHashMap可以看成是 LinkedList + HashMap。
 * LinkedHashMap继承HashMap，拥有HashMap的所有特性，并且额外增加了按一定顺序访问的特性。
 * HashMap使用（数组 + 单链表 + 红黑树）的存储结构, LinkedHashMap继承了HashMap，所以它的内部也有这三种结构，但是它还额外添加了一种“双向链表”的结构存储所有元素的顺序。
 *
 * （1）LinkedHashMap继承自HashMap，具有HashMap的所有特性；
 * （2）LinkedHashMap内部维护了一个双向链表存储所有的元素；
 * （3）如果accessOrder为false，则可以按插入元素的顺序遍历元素；
 * （4）如果accessOrder为true，则可以按访问元素的顺序遍历元素；
 * （5）LinkedHashMap的实现非常精妙，很多方法都是在HashMap中留的钩子（Hook），直接实现这些Hook就可以实现对应的功能了，并不需要再重写put()等方法；
 * （6）默认的LinkedHashMap并不会移除旧元素，如果需要移除旧元素，则需要重写removeEldestEntry()方法设定移除策略；
 * （7）LinkedHashMap可以用来实现LRU缓存淘汰策略；
 *
 */
public class LinkedHasMapTest {
    public static void main(String[] args) {
        Map<String, String> accessOrderFalse = new LinkedHashMap<>();
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


        Set<Map.Entry<String, String>> set = accessOrderTrue.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
