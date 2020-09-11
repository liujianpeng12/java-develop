import java.util.Collections;
import java.util.HashMap;

/**
 * （1）HashMap是一种散列表，采用（数组 + 链表 + 红黑树）的存储结构；
 * （2）HashMap的默认初始容量为16（1<<4），默认装载因子为0.75f，容量总是2的n次方；
 * （3）HashMap扩容时每次容量变为原来的两倍；
 * （4）当桶的数量小于64时不会进行树化，只会扩容；
 * （5）当桶的数量大于64且单个桶中元素的数量大于8时，进行树化；
 * （6）当单个桶中元素数量小于6时，进行反树化；
 * （7）HashMap是非线程安全的容器；
 * （8）HashMap查找添加元素的时间复杂度都为O(1)；
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("123".hashCode());
        int hash = hash("61");
        System.out.println(hash);
        System.out.println((10 - 1) & hash);

        System.out.println(1 << 4);

        Collections.synchronizedMap(new HashMap<>()).put("1", "a");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
