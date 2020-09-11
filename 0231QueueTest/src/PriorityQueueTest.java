import java.util.PriorityQueue;
import java.util.Random;

/**
 * Queue是一种叫做队列的数据结构，队列是遵循着一定原则的入队出队操作的集合，一般来说，入队是在队列尾添加元素，出队是在队列头删除元素，但是，也不一定，比如优先级队列的原则就稍微有些不同。
 *
 * 在 Java 中 PriorityQueue 是一个使用数组结构来存储元素的优先队列，虽然它也实现了Queue接口，
 * 但是元素存取并不是先进先出，而是通过一个二叉小顶堆实现的，默认底层使用自然排序规则给插入的元素进行排序，
 * 也可以使用自定义比较器来实现排序，每次取出的元素都是队列中权值最小的。
 *
 * （1）PriorityQueue是一个小顶堆；
 * （2）PriorityQueue是非线程安全的；
 * （3）PriorityQueue不是有序的，只有堆顶存储着最小的元素；
 * （4）入队就是堆的插入元素的实现；
 * （5）出队就是堆的删除元素的实现；
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        System.out.println("插入的数据");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10 ; i++) {
            Integer num = new Random().nextInt(100);
            System.out.print(num + ",");
            priorityQueue.offer(num);
        }

        System.out.println("");
        System.out.println("插入后的数据");
        while(true) {
            Integer number = priorityQueue.poll();
            if(number == null) {
                break;
            }
            System.out.print(number + ",");
        }
    }
}
