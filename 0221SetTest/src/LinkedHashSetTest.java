import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet继承自HashSet，它的添加、删除、查询等方法都是直接用的HashSet的，唯一的不同就是它使用LinkedHashMap存储元素。
 *
 * （1）LinkedHashSet的底层使用LinkedHashMap存储元素。
 * （2）LinkedHashSet是有序的，它是按照插入的顺序排序的。
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<String>();
        System.out.println("linkedHashSet初始容量大小："+linkedHashSet.size());
        linkedHashSet.add("1");
        linkedHashSet.add("4");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        linkedHashSet.add("3");
        linkedHashSet.add("2");
        linkedHashSet.add(null);
        linkedHashSet.add(null);

        System.out.println("linkedHashSet容量大小："+linkedHashSet.size());
        //迭代器遍历
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str + ",");
        }

        System.out.println("\n===========");
        //增强for循环
        for (String str : linkedHashSet) {
            System.out.print(str + ",");
        }
    }
}
