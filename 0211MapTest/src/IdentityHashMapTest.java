import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        Map identityMaps = new IdentityHashMap<String, String>();
        identityMaps.put(new String("aa"), "aa");
        identityMaps.put(new String("aa"), "bb");
        identityMaps.put(new String("aa"), "cc");
        identityMaps.put(new String("aa"), "dd");
        identityMaps.put("bb", "bb");
        identityMaps.put("bb", "bb2");
        System.out.println("数据长度:"+identityMaps.size()+",输出结果:"+identityMaps);
    }
}
