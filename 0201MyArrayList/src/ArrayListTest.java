import java.util.ArrayList;
import java.util.List;

/**
 * （1）ArrayList内部使用数组存储元素，当数组长度不够时进行扩容，每次加一半的空间，ArrayList不会进行缩容；
 * （2）ArrayList支持随机访问，通过索引访问元素极快，时间复杂度为O(1)；
 * （3）ArrayList添加元素到尾部极快，平均时间复杂度为O(1)；
 * （4）ArrayList添加元素到中间比较慢，因为要搬移元素，平均时间复杂度为O(n)；
 * （5）ArrayList从尾部删除元素极快，时间复杂度为O(1)；
 * （6）ArrayList从中间删除元素比较慢，因为要搬移元素，平均时间复杂度为O(n)；
 * （7）ArrayList支持求并集，调用addAll(Collection c)方法即可；
 * （8）ArrayList支持求交集，调用retainAll(Collection c)方法即可；
 * （7）ArrayList支持求单向差集，调用removeAll(Collection c)方法即可；
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //一半值
        System.out.println(10 >> 1);

        //两倍值
        System.out.println(3333 << 1);

        List<String> arraylist = new ArrayList<>();
        //arraylist.add(2, "2");

        arraylist.add("1");
        arraylist.add("2");
        arraylist.add("3");
        arraylist.remove(1);
    }
}
