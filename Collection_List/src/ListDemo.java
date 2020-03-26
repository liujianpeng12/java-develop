import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ListDemo {

	public static void main(String[] args) {
		arrayList();
		System.out.println("-------------------------------");
		linkedList();
		System.out.println("-------------------------------");
		vector();
		System.out.println("-------------------------------");
		copyOnWriteArrayList();
	}

	/**
	 * ArrayList:
	 * 1、ArrayList内部实现采用Object对象数组
	 * 2、默认初始容量为10（对象数组的大小）
	 * 3、当添加对象时超出数组大小，那么将该对象数组进行扩充（扩充算法：当前容量的一半）
	 * 4、ArrayList删除、插入的效率低（原因需要移动其它元素）
	 * 5、好处，查找方便，遍历快
	 * 6、如果存储的元素个数较明确，那么可以在构造ArrayList时使用带初始容量的构造器
	 * 7、在同一个List对象集合中，通常情况只存入一种类型的对象
	 * 		jdk1.5后，在声明集合对象时可使用泛型约束集合的存储类型
	 * 8、ArrayList是线程不安全的，效率高
	 * 9、jdk1.2开始
	 * 
	 */
	public static void arrayList() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("11");
		list.add("bb");
		System.out.println(list.size());
		for (String string : list) {
			System.out.print(" " + string);
		}
	}
	
	/**
	 * LinkedList：
	 * 1、使用链表数据结构实现
	 * 2、该集合具备链表的所有优点(插入，删除快)
	 * 3、LinkedList实现了queue队列接口，可以做为队列数据结构使用
	 * 
	 */
	public static void linkedList(){
		List<String> list=new LinkedList<String>();
		list.add("aa");
		list.add("bb");
		list.add("aa");
		System.out.println(list.size());
		for (String string : list) {
			System.out.print(" " + string);
		}
		//作为队列使用
		Queue<String> queue=new LinkedList<String>();
		queue.add("cc");
		queue.add("dd");
		queue.add("22");
		queue.poll();////从队列中获取并移除队列头
		System.out.println("\n当前队列的头是："+queue.element());
	}
	
	
	/**
	 * Vector:
	 * 与ArrayList集合实现原理相同
	 * 线程安全的,但效率低
	 * 对象数组的扩充方式默认为原数组的2倍
	 */
	public static void vector(){
		List<String> list=new Vector<String>();
		list.add("ff");
		list.add("gg");
		System.out.println(list.size());
	}
	
	public static void copyOnWriteArrayList(){ReentrantLock
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("ca");
		list.add("cb");
		System.out.println(Arrays.toString(list.toArray()));
	}
}
