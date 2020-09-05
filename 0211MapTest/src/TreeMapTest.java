import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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
