import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * （1）CopyOnWriteArrayList使用ReentrantLock重入锁加锁，保证线程安全；
 * （2）CopyOnWriteArrayList的写操作都要先拷贝一份新数组，在新数组中做修改，修改完了再用新数组替换老数组，所以空间复杂度是O(n)，性能比较低下；
 * （3）CopyOnWriteArrayList的读操作支持随机访问，时间复杂度为O(1)；
 * （4）CopyOnWriteArrayList采用读写分离的思想，读操作不加锁，写操作加锁，且写操作占用较大内存空间，所以适用于读多写少的场合；
 * （5）CopyOnWriteArrayList只保证最终一致性，不保证实时一致性；
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        CountDownLatch latch = new CountDownLatch(num);
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i=0; i<num; i++) {
            int k = i;
            new Thread(()->{
                list.add(k);
                latch.countDown();
            }).start();
        }
        latch.await();
        Collections.sort(list);
        System.out.println("size=" + list.size());
        System.out.println(list.toString());

    }
}
