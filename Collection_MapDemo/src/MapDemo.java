import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class MapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hashMap();
		treeMap();
		System.out.println("-------------------------------");
		linkedHashMap();

		System.out.println("-------------------------------");
		concurrentHashMap();
	}

	/**
	 *HashMap:
	 * 1、基于哈希表的 Map 接口的实现:对象数组+链表
	 * 2、允许使用 null 值和 null 键
	 * 3、不确定顺序
	 * 4、相同的键值以最后覆盖的方式进行存储
	 * 5、默认的数组容量大小是16，加载因子是0.75
	 * 6、对象的存储算法：先获取该对象的hashCode值，对HashMap的容量取余的值为该对象
	 * 	在数组中的位置。
	 * 7、查找对象，获取该对象的hashCode值对当前容量取余的值为下标，查找指定数组位置
	 * 的对象（如果对象在多级链表中，则遍历）
	 * 8、哈希表的重新散列（数组重新扩充），会消耗很大的性能，所以要尽量避免
	 * 9、如果存储的对象数量可预知，那么可以使用自定义初始容量和加载因子（带参构造器）
	 * 10、线程不安全
	 */
	public static void hashMap(){
		Map<Integer,String> m=new HashMap<Integer,String>();
		m.put(1, "a");
		m.put(2, "cc");
		Set<Integer> keys=m.keySet();
		Iterator<Integer> ite=keys.iterator();
		while(ite.hasNext()){
			System.out.println(m.get(ite.next()));
		}
	}

	/**
	 * Hashtable
	 * 与HashMap相似
	 * 不允许键值为null
	 * 用默认初始初始容量11和加载因子0.75构造一个新的空哈希表
	 * 线程安全的,同步
	 */
	public static void hashtable(){
		Hashtable<Integer,String> t=new Hashtable<Integer,String>();
		t.put(1, "sew");
	}

	/**
	 * TreeMap
	 * 基于二叉树中的红黑树实现,红黑树是一个自平衡的排序二叉树
	 * 使用键的自然顺序构造一个新的、空的树映射
	 * 使用自定义对象作为KEY值时,该对象应实现 Comparable接口
	 */
	public static void treeMap(){
		Map<Person,String> m=new TreeMap<Person,String>();
		m.put( new Person(12,"aaa"),"e");
		m.put( new Person(34,"bbc"),"oos");
		m.put( new Person(23,"yu"),"fw");
		System.out.println(m.size());
		Set<Entry<Person,String>> ps=m.entrySet();
		Iterator<Entry<Person,String>> it=ps.iterator();
		while(it.hasNext()){
			Entry<Person,String> en=it.next();
			System.out.println(en.getValue()+":"+en);
		}
	}

	/**
	 *  LinkedHashMap:
	 * 是HashMap的子类
	 * 具有可预知的迭代顺序。
	 * 此实现与 HashMap 的不同之处在于，后者维护着一个运行于所有条目的双重链接列表。
	 * 此链接列表定义了迭代顺序，该迭代顺序通常就是将键插入到映射中的顺序（插入顺序）。
	 */
	public static void linkedHashMap(){
		Map<Person,String> m=new LinkedHashMap<Person,String>();
		m.put( new Person(12,"aaa"),"e");
		m.put( new Person(23,"bbc"),"oos");
		m.put( new Person(34,"yu"),"fw");
		System.out.println(m.size());
		Collection<String> ss=m.values();
		for(String s:ss){
			System.out.println(s);
		}
	}

	public static void concurrentHashMap(){
		ConcurrentHashMap<Person, String> map = new ConcurrentHashMap<>();
		map.put( new Person(12,"aaa"),"ca");
		map.put( new Person(23,"bbc"),"cb");
		map.put( new Person(34,"yu"),"cc");

		Set<Entry<Person, String>> set = map.entrySet();
		Iterator<Entry<Person, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<Person, String> en = it.next();
			System.out.println(en.getValue() + ":" + en);
		}
	}
}

class Person implements Comparable<Person> {
	private int age;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Person o) {
		if(null==o)
			throw new NullPointerException("");
		if(o.age>this.age)
			return 1;
		else if(o.age<=this.age)
			return -1;
		return 0;
	}
}