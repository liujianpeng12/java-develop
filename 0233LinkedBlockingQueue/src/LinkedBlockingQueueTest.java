import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue是java并发包下一个以单链表实现的阻塞队列，它是线程安全的
 *
 * （1）LinkedBlockingQueue采用单链表的形式实现；
 * （2）LinkedBlockingQueue采用两把锁的锁分离技术实现入队出队互不阻塞；
 * （3）LinkedBlockingQueue是有界队列，不传入容量时默认为最大int值；
 *
 * LinkedBlockingQueue与ArrayBlockingQueue对比？
 * a）后者入队出队采用一把锁，导致入队出队相互阻塞，效率低下；
 * b）前者入队出队采用两把锁，入队出队互不干扰，效率较高；
 * c）二者都是有界队列，如果长度相等且出队速度跟不上入队速度，都会导致大量线程阻塞；
 * d）前者如果初始化不传入初始容量，则使用最大int值，如果出队速度跟不上入队速度，会导致队列特别长，占用大量内存；
 */
public class LinkedBlockingQueueTest {

    static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //queue.add(finalI);//如果队列已满，报java.lang.IllegalStateException: Queue full 错误
                    //queue.offer(finalI);//如果队列已满，程序正常运行，只是不再新增元素
                    try {
                        queue.put(finalI);//如果队列已满，阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("入队列:" + finalI);
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int e = 0;
                    try {
                        e = queue.take();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("出队列:" + e);
                }
            }).start();
        }
    }
}
