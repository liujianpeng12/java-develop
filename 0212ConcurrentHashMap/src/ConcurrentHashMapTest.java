import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * （1）ConcurrentHashMap是HashMap的线程安全版本；
 * （2）ConcurrentHashMap采用（数组 + 链表 + 红黑树）的结构存储元素；
 * （3）ConcurrentHashMap相比于同样线程安全的HashTable，效率要高很多；
 * （4）ConcurrentHashMap采用的锁有 synchronized，CAS，自旋锁，分段锁，volatile等；
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "1");
        map.put("g", "3");
        map.put("c", "2");

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 使用ConcurrentHashMap也会造成线程不安全的问题
     * if之前可能有其它线程已经put()了这个元素，这时候再put()就把那个线程put()的元素覆盖了。
     * @param map
     * @param key
     * @param value
     */
    public void unsafeUpdate(ConcurrentHashMap<String, String> map, String key, String value) {
        String v = map.get(key);
        if(v == null) {
            map.put(key, value);
        }
    }
}
