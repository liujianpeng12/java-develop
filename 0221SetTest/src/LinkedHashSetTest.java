import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet 输入输出有序
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
