import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在我们这里 Atomic 是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰
 * @author Administrator
 *
 */
public class AtomicTest {

	public static void main(String[] args){
		AtomicInteger count = new AtomicInteger(0);
		System.out.println(count);
		
		count.incrementAndGet();
		System.out.println(count);
		
		int temvalue = 0;
		
		temvalue = count.getAndSet(3);
		System.out.println("temvalue:" + temvalue + ";  count:" + count);//temvalue:0;  count:3
		temvalue = count.getAndIncrement();
		System.out.println("temvalue:" + temvalue + ";  count:" + count);//temvalue:3;  count:4
	}
}
