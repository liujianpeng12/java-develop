import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
