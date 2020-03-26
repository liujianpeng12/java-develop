package com.vince.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射
 * 
 * @author Administrator
 * 
 */
public class RefDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			ClassLoader.getSystemClassLoader().loadClass("com.vince.ref.Person");
			System.out.println("------------");
			//根据运行结果得出Class.forName加载类是将类进了初始化，而ClassLoader的loadClass并没有对类进行初始化，只是把类加载到了虚拟机中。
			Class c5 = Class.forName("com.vince.ref.Person");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Person p1 = new Person("a", 12);
		Person p2 = new Person("b", 13);

		// 一个Class通过类加载器加载到JVM中
		// 一个Class对象代表一份字节码,相同类型的对象的字节码相同
		// 创建Class对象方式一
		Class c1 = p1.getClass();
		Class c2 = p2.getClass();
		System.out.println(c1 == c2);
		// 创建Class对象方式二
		Class c3 = Person.class;
		System.out.println(c1 == c3);
		// 创建Class对象方式三
		Class c4 = null;
		try {
			c4 = Class.forName("com.vince.ref.Person");
			System.out.println(c2 == c4);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// ------------通过类信息实例化对象
		// 调用无参数构造方法(被构造的类中需要有无参数的构造方法)
		try {
			Person p3 = (Person) c4.newInstance();
			System.out.println(p3);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		// 调用有参数构造
		Person p4 = null;
		try {
			Constructor c = c4.getConstructor(String.class, int.class);
			p4 = (Person) c.newInstance("c", 19);
			System.out.println(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------获取类信息----------------");
		System.out.println("包名:" + c4.getPackage().getName());
		System.out.println("类名:" + c4.getName());
		Method[] m1 = c4.getMethods();
		for (int i = 0; i < m1.length; i++) {
			System.out.println("方法名:" + m1[i].getName());
		}
		System.out.println("-----------getDeclaredMethods---------");
		Method[] m2 = c4.getDeclaredMethods();
		for (int i = 0; i < m2.length; i++) {
			System.out.println("方法名:" + Modifier.toString(m2[i].getModifiers())
					+ " " + m2[i].getName());
		}

		System.out.println("----------获取属性----------");
		Field[] fs = c4.getFields();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
		System.out.println("------------------");
		Field[] fs2 = c4.getDeclaredFields();
		for (int i = 0; i < fs2.length; i++) {
			System.out.println(fs2[i].getName());
		}

		System.out.println("----------调用方法----------");
		try {
			// 调用公有方法
			Method setNameMethod = c4.getMethod("setName", String.class);
			setNameMethod.invoke(p4, "cc");// p4.setName("cc");
			System.out.println(p4);
			// 调用私有方法
			Method sayMethod = c4.getDeclaredMethod("say");
			sayMethod.setAccessible(true);// 忽略检查方法修饰符
			sayMethod.invoke(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------调用属性----------");
		try {
			Field ageField = c4.getDeclaredField("age");
			ageField.setAccessible(true);//忽略检查方法修饰符
			System.out.println(ageField.get(p4));
			ageField.set(p4, 20);
			System.out.println(p4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Person {
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	static{
		System.out.println("Person static!!!");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	private void say() {
		System.out.println("my name is " + name);
	}

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
}