import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 跳表
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247483760&idx=1&sn=5d230c3e16cc92222ffa2813b98a7dd6&scene=21#wechat_redirect
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247483771&idx=1&sn=3abb7b11f6fed1e61fd2e2d93106d8c5&scene=21#wechat_redirect
 */
public class ConcurrentSkipListMapTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, String> csm = new ConcurrentSkipListMap<>();
        csm.put("a", "2");
        csm.put("dd", "哈");
        csm.put("b", "null");

        Set<Map.Entry<String, String>> set = csm.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
