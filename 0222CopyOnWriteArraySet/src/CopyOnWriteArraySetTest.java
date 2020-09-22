import java.util.concurrent.CopyOnWriteArraySet;

/**
 * （1）CopyOnWriteArraySet是用CopyOnWriteArray实现的；
 * （2）CopyOnWriteArraySet是有序的, 按插入的顺序排序，因为底层其实是数组，数组是有序的
 *  (3）CopyOnWriteArraySet是并发安全的，而且实现了读写分离；
 * （4）CopyOnWriteArraySet通过调用CopyOnWriteArrayList的addIfAbsent()方法来保证元素不重复；
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("3");
        set.add("1");
        set.add("2");
        for (String str : set) {
            System.out.println(str);
        }
    }
}
