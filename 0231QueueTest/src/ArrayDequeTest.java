import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Queue是一种叫做队列的数据结构，队列是遵循着一定原则的入队出队操作的集合，一般来说，入队是在队列尾添加元素，出队是在队列头删除元素，但是，也不一定，比如优先级队列的原则就稍微有些不同。
 *
 * 双端队列是一种特殊的队列，它的两端都可以进出元素，故而得名双端队列。
 * ArrayDeque是一种以数组方式实现的双端队列，它是非线程安全的。
 *
 * （1）ArrayDeque是采用数组方式实现的双端队列；
 * （2）ArrayDeque的出队入队是通过头尾指针循环利用数组实现的；
 * （3）ArrayDeque容量不足时是会扩容的，每次扩容容量增加一倍；
 * （4）ArrayDeque可以直接作为栈使用；
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast("34");
        arrayDeque.offerFirst("12");
        Iterator<String> iterator = arrayDeque.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
