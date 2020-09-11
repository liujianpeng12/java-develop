import java.util.Map;
import java.util.WeakHashMap;

/**
 * （1）WeakHashMap使用（数组 + 链表）存储结构；
 * （2）WeakHashMap中的key是弱引用，gc的时候会被清除；
 * （3）每次对map的操作都会剔除失效key对应的Entry；
 * （4）使用String作为key时，一定要使用new String()这样的方式声明key，才会失效，其它的基本类型的包装类型是一样的；
 * （5）WeakHashMap常用来作为缓存使用；
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test2() {
        Map<String, Integer> map = new WeakHashMap<>(3);

        // 放入3个new String()声明的字符串
        map.put(new String("1"), 1);
        map.put(new String("2"), 2);
        map.put(new String("3"), 3);

        //未gc输出所有数据: {1=1, 2=2, 3=3}
        System.out.println(map);

        // 放入不用new String()声明的字符串
        //在这里通过new String()声明的变量才是弱引用，使用"6"这种声明方式会一直存在于常量池中，不会被清理，所以"6"这个元素会一直在map里面，其它的元素随着gc都会被清理掉。
        map.put("6", 6);

        // 使用key强引用"3"这个字符串
        String key = null;
        for (String s : map.keySet()) {
            // 这个"3"和new String("3")不是一个引用
            if(s.equalsIgnoreCase("3")) {
                key = s;
            }
        }

        //未gc输出所有数据: {6=6, 1=1, 2=2, 3=3}
        System.out.println(map);

        //gc一下
        System.gc();

        //
        map.put(new String("4"), 4);

        //输出{4=4, 6=6, 3=3}, gc后放入的值和强引用的key可以打印出来
        System.out.println(map);

        // key与"3"的引用断裂
        key = null;

        //gc一下
        System.gc();

        // 输出{6=6}，gc后强引用的key可以打印出来
        System.out.println(map);
    }

    private static void test1() {
        Map weakHashMap = new WeakHashMap();

        for (int i = 0; i < 5; i++) {
            weakHashMap.put("key-" + i, "value-" + i);
        }

        System.out.println("数组长度："+weakHashMap.size() + "，输出结果：" + weakHashMap);

        //主动触发一次GC
        System.gc();

        System.out.println("数组长度："+weakHashMap.size() + "，输出结果：" + weakHashMap);
    }
}
