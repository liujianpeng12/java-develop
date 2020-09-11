import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * LinkedList是一个以双向链表实现的List，它除了作为List使用，还可以作为队列或者栈来使用
 *
 *  LinkedLit实现了 List, Deque 接口
 * （1）LinkedList是一个以双链表实现的List；
 * （2）LinkedList还是一个双端队列，具有队列、双端队列、栈的特性；
 * （3）LinkedList在队列首尾添加、删除元素非常高效，时间复杂度为O(1)；
 * （4）LinkedList在中间添加、删除元素比较低效，时间复杂度为O(n)；
 * （5）LinkedList不支持随机访问，所以访问非队列首尾的元素比较低效；
 * （6）LinkedList在功能上等于ArrayList + ArrayDeque；
 */
public class LinkedListTest {
    public static void main(String[] args){

        //LinkedList作为List来使用
        List<String> list = new LinkedList<>();
        list.add("1s");
        list.add(0, "0s");
        for (String s : list) {
            System.out.println(s);
        }

        //LinkedList作为Deque来使用
        Deque<String> deque = new LinkedList<>();
        deque.offer("a");
        deque.addLast("d");
        for (String s : deque){
            System.out.println(s);
        }

        //LinkedList作为栈来使用,栈的特性是LIFO(Last In First Out)
        Deque<String> deque2 = new LinkedList<>();
        deque2.push("cc");
        deque2.push("ee");
        while (true) {
            String s = deque2.poll();
            if(Objects.isNull(s)) {
                break;
            }
            System.out.println(s);
        }
    }
}
