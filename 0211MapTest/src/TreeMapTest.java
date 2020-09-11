import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * （1）TreeMap的存储结构只有一颗红黑树；
 * （2）TreeMap中的元素是有序的，按key的顺序排列；
 * （3）TreeMap比HashMap要慢一些，因为HashMap前面还做了一层桶，寻找元素要快很多；
 * （4）TreeMap没有扩容的概念；
 * （5）TreeMap的遍历不是采用传统的递归式遍历；
 * （6）TreeMap可以按范围查找元素，查找最近的元素；
 *
 * 红黑树:
 * （1）每个节点或者是黑色，或者是红色。
 * （2）根节点是黑色。
 * （3）每个叶子节点（NIL）是黑色。（注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！）
 * （4）如果一个节点是红色的，则它的子节点必须是黑色的。
 * （5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map initMap = new TreeMap();
        initMap.put("4", "d");
        initMap.put("3", "c");
        initMap.put("1", "a");
        initMap.put("2", "b");
        //默认自然排序，key为升序
        System.out.println("默认 排序结果:" + initMap.toString());

        Map comparatorMap = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //根据key比较大小，采用倒序，以大到小排序
                return o2.compareTo(o1);
            }
        });
        comparatorMap.put("4", "d");
        comparatorMap.put("3", "c");
        comparatorMap.put("1", "a");
        comparatorMap.put("2", "b");
        System.out.println("自定义 排序结果:" + comparatorMap.toString());
    }
}
