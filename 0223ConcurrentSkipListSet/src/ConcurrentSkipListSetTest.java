import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * ConcurrentSkipListSet底层是通过ConcurrentNavigableMap来实现的，它是一个有序的线程安全的集合
 * （1）ConcurrentSkipListSet底层是使用ConcurrentNavigableMap实现的；
 * （2）ConcurrentSkipListSet有序的，基于元素的自然排序或者通过比较器确定的顺序；
 * （3）ConcurrentSkipListSet是线程安全的；
 */
public class ConcurrentSkipListSetTest {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
        set.add("a");
        set.add("c");
        set.add("b");

        for (String str : set) {
            System.out.println(str);
        }
    }
}
