import java.util.*;


public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hashSet();
		treeSet();
		linkedHashSet();
	}
	
	/**
	 * LinkedHashSet
	 * 使用哈希表+双向链接
	 * 会以插入顺序输出
	 * 底层使用LinkHashMap实现
	 */
	public static void linkedHashSet(){
		System.out.println("---------------------------------------");
		Emp p1=new Emp("aa",23);
		Emp p2=new Emp("bb",24);
		Emp p3=new Emp("cc",17);
		Emp p4=new Emp("ddb",16);
		Set<Emp> persons=new LinkedHashSet<Emp>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		System.out.println(persons);
	}
	
	/**
	 * TreeSet
	 * 有序的
	 * 底层使用TreeMap实现
	 * 若在TreeSet中存储自定义对象时，须实现Comparable接口
	 */
	public static void treeSet(){
		System.out.println("---------------------------------------");
		Emp p1=new Emp("aa",23);
		Emp p2=new Emp("bb",24);
		Emp p3=new Emp("cc",17);
		Emp p4=new Emp("ddb",16);
		Set<Emp> persons=new TreeSet<Emp>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(new Emp("tt",23));//23重复
		System.out.println(persons.size());
		
		Emp[] emps=persons.toArray(new Emp[]{});
		for(Emp e : emps){
			System.out.println(e.getAge());
		}
	}
	
	/**
	 * HashSet 
	 * 不保证迭代顺序
	 * 底层使用HashMap实现
	 * 把存入的对象作为HashMap的Key值，而HashMap的Value值使用同一个Object对象
	 * 迭代方式：
	 * 		1)使用迭代器Iterator遍历（推荐）
	 * 		2)foreach遍历 
	 * 		3)把set集合转换成数组进行遍历
	 * 不包含重复元素的 collection。更确切地讲，set 不包含满足 e1.equals(e2) 的元素对 e1 和 e2
	 */
	public static void hashSet(){
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("b");
		System.out.println(set.size());
		
		String[] arr= set.toArray(new String[]{});
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		System.out.println("---------------------------------------");
		Person p1=new Person("aa",23);
		Person p2=new Person("bb",23);
		Person p3=new Person("cc",23);
		Person p4=new Person("ddb",23);
		Set<Person> persons=new HashSet<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(new Person("cc",23));//重复的
		System.out.println(persons.size());
		
	}
}
/**
 * 判断对象是否相等，先判断hashcode,再判断equals
 * @author Administrator
 *
 */
class Person{
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

class Emp implements Comparable<Emp>{
	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	@Override
	public int compareTo(Emp o) {
		if(null==o)
			throw new NullPointerException("");
		if(this.age>o.age)
			return -1;
		if(this.age<o.age)
			return 1;
		return 0;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + "]";
	}
	
	
}
