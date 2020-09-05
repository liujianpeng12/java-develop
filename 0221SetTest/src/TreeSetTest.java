import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
