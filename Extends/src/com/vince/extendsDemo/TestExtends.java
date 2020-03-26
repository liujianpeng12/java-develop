package com.vince.extendsDemo;

import java.util.Arrays;
import java.util.Collections;

/**
 * 继承
 * 1.只允许单继承
 * 2.子类可以继承父类的非私有的属性和方法,构造方法不能被继承
 * 3.子类的实例化过程:先调用父类的构造方法,如果父类没有默认的构造方法,那么子必须显示的调用父类带参数的构造方法
 * 4.方法重写:子类中的方法与父类中的方法相同(方法名相同,参数类型与个数完全相同,返回值相同,方法权限修饰符大于等于父类)
 * 		构造方法不能被重写
 * @author Administrator
 *
 */

class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void eat(){
		System.out.println("person eat...");
	}
}
class Chinese extends Person{

	public Chinese(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println("中国人吃米饭面条");
	}
}

class USA extends Person{

	public USA(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void eat() {
		System.out.println("美国人吃面包和肉");
	}
}

class USAC extends USA{

	public USAC(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
}

public class TestExtends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chinese c=new Chinese("aaa",21);
		c.eat();
		
		USA u=new USA("SSW",32);
		u.eat();
		
		//USAC uc = (USAC) u;//java.lang.ClassCastException异常
		
		byte a = 117;
		byte b = 127;
		//a = a + b;//错误
		a += b;
		System.out.println(a);
		
		double d1 = 333.2d;
		//long l1 = d1;//错误
		
		boolean f1 = 3 * 0.1 == 0.3;
		System.out.println(f1);//false
		
		String s1 = "aa";
		switch(s1){
		case "1":
			break;
		default:
				break;
		}
		
//		int[] ssw = {1,7,3,2};
//		Arrays.sort(ssw);
//		System.out.println(Arrays.toString(ssw));
		
	}

}
