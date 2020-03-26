import java.util.*;
import java.util.Map.Entry;

/**
 * 泛型 
 * 泛型相关术语 
 * ArrayList<E>:E 称为类型变量或类型参数 
 * ArrayList<Integer>: 称为参数化的类型
 * ArrayList<Integer>: 中的Integer称为类型参数的实例或实际参数类型 
 * ArrayList<Integer>: <> 称为type of 
 * ArrayLIst: 称为原始类型
 * 
 * @author Administrator
 * 
 */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person<Integer> p1 = new Person<Integer>("小明", 3);
		Person<Float> p2 = new Person<Float>("小黄", 2.5f);
		Person<String> p3 = new Person<String>("小高", "两岁");
		
		int age1 = p1.getAge();
		float age2 = p2.getAge();
		String age3 = p3.getAge();

		// 参数化类型与原始类型的兼容属性
		Collection<String> c = new Vector();
		Collection c2 = new Vector<String>();
		// 参数化类型不考虑数据参数的继承关系
		// ArrayList<String> c3=new ArrayList<Object>();//错误
		// ArrayList<Object> c4=new ArrayList<String>();//错误

		// 正确
		ArrayList c5 = new ArrayList<String>();// c5为ArrayList<Object>
		ArrayList<Object> c6 = c5;

		// 定义数组不能使用泛型
		// ArrayList<String>[] c7 = new ArrayList<String>()[10];//错误

		// 泛型擦除
		Person p4 = new Person("小刘", 5);
		Object age4 = p4.getAge();
		
		//使用通配符[?]
		Person<Float> p5 = new Person<Float>("小淡", 2.5f);
		Person<String> p6 = new Person<String>("小区", "两岁");
		//p5=p6;//错误,参数化类型不同,不能相互赋值		
		print(p5);
		print(p6);
		
		
		//使用泛型上限
		Person2<Integer> p7=new Person2<Integer>("小人",5);
		Person2<Double> p8=new Person2<Double>("小人",5.9d);
		//Person2<String> p7=new Person2<String>("小人",5);//错误:T只能是Number或Number的子类
		
		//使用泛型下限:表示只有使用具体类(String)或其父类(Object)
		Person<Integer> p9=new Person<Integer>("小入",5);
		Person<String> p10=new Person<String>("小为","三岁");
		//print2(p9);//错误:Integer类不是String类或String类的父类
		print2(p10);
		
		
		//使用泛型方法
		String[] name={"小你","小粉","小休"};
		name=func(name,0,1);
		for(String s:name){
			System.out.println(s);
		}
		
		//泛型的嵌套使用
		//Set<Entry<Integer,String>> entrys=map.entrySet();
		
	}
	
	/**
	 * 使用通配符[?]定义参数
	 * @param c
	 */
	private static void print(Person<?> c){
		//c.setAge(10);//错误,使用通配符时只能获取不能修改
		System.out.println("年龄是: "+c.getAge());
	}
	
	/**
	 * 使用泛型下限:表示只有使用具体类(String)或其父类(Object)
	 * @param c
	 */
	private static void print2(Person<? super String> c){
		//c.setAge(10);//错误,使用通配符时只能获取不能修改
		System.out.println("年龄是: "+c.getAge());
	}
	
	/**
	 * 使用泛型定义方法
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	private static <T> T[] func(T[] array,int i,int j){
		T temp=array[i];
		array[i]=array[j];
		array[j]=temp;
		return array;
	}
	
	public static <T> T func3(T[] tt){
		return null;
		
	}
	
	private static <T> int func2(T[] i){
		return 0;
	}
	
	private <T> T func4(T t){
		return t;
		
	}
	
	private <T> String func5(T t){
		return null;
		
	}
}

class Person<T> {
	private String name;
	private T age;

	public Person(String name, T age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}
}

/**
 * 泛型:使用泛型上限:表示T只能是Number或Number的子类
 * @author Administrator
 *
 * @param <T>
 */
class Person2<T extends Number> {
	private String name;
	private T age;

	public Person2(String name, T age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}
}

/**
 * 使用泛型定义接口
 * @author Administrator
 *
 * @param <T>
 */
interface IEat<T>{
	void eat(T food);
}
class IEatImpl<T> implements IEat<T>{

	@Override
	public void eat(T food) {
		
	}
	
}







