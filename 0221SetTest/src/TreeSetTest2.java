import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {
        Set<Person> treeSet = new TreeSet<Person>();
        System.out.println("HashSet初始容量大小："+treeSet.size());
        treeSet.add(new Person(18, "李一"));
        treeSet.add(new Person(17, "李二"));
        treeSet.add(new Person(19, "李三"));
        treeSet.add(new Person(21, "李四"));
        treeSet.add(new Person(20, "李五"));

        //相同元素会自动覆盖
        System.out.println("treeSet容量大小："+treeSet.size());
        System.out.println("按照年龄从小到大，自定义排序结果：");

        Iterator<Person> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n===========");
        //增强for循环
        for(Person p : treeSet) {
            System.out.println(p);
        }

    }
}
