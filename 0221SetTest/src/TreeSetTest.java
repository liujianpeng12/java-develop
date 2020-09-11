import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * （1）TreeSet底层使用NavigableMap存储元素；
 * （2）TreeSet是有序的；
 * （3）TreeSet是非线程安全的；
 * （4）TreeSet实现了NavigableSet接口，而NavigableSet继承自SortedSet接口；
 * （5）TreeSet实现了SortedSet接口；
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        System.out.println("treeSet初始容量大小："+treeSet.size());
        treeSet.add("1");
        treeSet.add("4");
        treeSet.add("3");
        treeSet.add("8");
        treeSet.add("5");

        System.out.println("treeSet容量大小："+treeSet.size());
        //迭代器遍历
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str + ",");
        }

        System.out.println("\n===========");
        //增强for循环
        for (String str : treeSet) {
            System.out.print(str + ",");
        }
    }
}
