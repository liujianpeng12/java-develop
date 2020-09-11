import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * （1）HashSet内部使用HashMap的key存储元素，以此来保证元素不重复；
 * （2）HashSet是无序的，因为HashMap的key是无序的；
 * （3）HashSet中允许有一个null元素，因为HashMap允许key为null；
 * （4）HashSet是非线程安全的；
 * （5）HashSet是没有get()方法的；
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();
        System.out.println("HashSet初始容量大小："+hashSet.size());
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add(null);

        //相同元素会自动覆盖
        System.out.println("HashSet容量大小："+hashSet.size());

        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n===========");
        //增强for循环
        for(String str : hashSet) {
            System.out.println(str);
        }

    }
}
