import java.util.Arrays;
import java.util.Comparator;


public class ComparatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person[] persons={new Person("lili",21),new Person("haha",19),new Person("yuyu",10),new Person("nunu",7)};
		Arrays.sort(persons,new PersonComparator());
		System.out.println(Arrays.toString(persons));

	}

}

class Person{
	public String name;
	public int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+":"+age;
	}
}

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(null==o1 || null==o2){
			throw new NullPointerException("");
		}
		if(o1.age<o2.age){
			return -1;
		}else if(o1.age>o2.age){
			return 1;
		}
		return 0;
	}
	
}