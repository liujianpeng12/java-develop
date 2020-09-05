import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * hashmap 多线程死循环测试
 * 需要在jdk1.7下
 */
public class HashMapDeadTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<>(2, 0.75f);
        map.put("1", "a");

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("2", "b");
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("3", "c");
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key:" + key + ",value:" + map.get(key));
        }
    }
}
