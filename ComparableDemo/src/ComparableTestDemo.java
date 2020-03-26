import java.util.Arrays;


public class ComparableTestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person[] persons={new Person("lili",21),new Person("haha",19),new Person("yuyu",10)};
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
		System.out.println("----------------------------------");
	}

}

class Person implements Comparable<Person>{
	public String name;
	public int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+":"+age;
	}
	@Override
	public int compareTo(Person o) {
		if(null==o){
			throw new NullPointerException("");
		}
		if(this.age<o.age){
			return -1;
		}
		else if(this.age>o.age){
			return 1;
		}
		return 0;
	}
}
