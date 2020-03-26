import java.util.*;

/**
 * 比较两个对象是否相等,通过比较hashCode()和equals(),hashCode相等的对象不一定相等
 * HashSet通过计算对象的hashCode()的值来存储对象到数组中,若对象的hashCode()改变后,在HashSet中就找不到该对象,
 * 如下面的修改年龄后再删除该对象,则不能删除成功
 * @author Administrator
 *
 */
public class HashCodeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Person> set=new HashSet<Person>();
		Person p1=new Person(12,"ad");
		//System.out.println(p1.hashCode());
		Person p2=new Person(12,"AD");
		//System.out.println(p2.hashCode());

		System.out.println("ad".hashCode());
		System.out.println("AD".hashCode());
		
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
		
		System.out.println("--------------------");
		
		p1.setAge(14);
		set.remove(p1);
		System.out.println(set.size());
	}

}

class Person{
	private int age;
	private String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
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
	public int hashCode() {
		System.out.println("判断hashcode");
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("判断equals");
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
