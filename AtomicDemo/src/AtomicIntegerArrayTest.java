import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temvalue = 0;
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		AtomicIntegerArray i = new AtomicIntegerArray(nums);
		for (int j = 0; j < nums.length; j++) {
			System.out.println(i.get(j));
		}
		
		temvalue = i.getAndSet(0, 2);
		System.out.println("temvalue:" + temvalue + ";  i:" + i);
		temvalue = i.incrementAndGet(0);
		System.out.println("temvalue:" + temvalue + ";  i:" + i);
		temvalue = i.getAndAdd(0, 10);
		System.out.println("temvalue:" + temvalue + ";  i:" + i);
		i.compareAndSet(0, 13, 4);
		temvalue = i.get(0);
		System.out.println("temvalue:" + temvalue + ";  i:" + i);
	}
}
