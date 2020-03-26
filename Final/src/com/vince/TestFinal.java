package com.vince;

/**
 * final
 * 1.使用final定义一个常量,常量值不能被修改,常量必须初始化(1.直接定义时赋值,2.在构造方法中赋值)
 * 2.使用final声明一个方法时,该方法不能被子类重写
 * 3.使用final声明的类不能被继承
 * @author Administrator
 *
 */

class Person{
	public final void eat(){
		System.out.println("person eat.");
	}
}

final class Annimal{
	
}

class Student extends Person{//,Annimal
	private final String name="abc";
	private final int age;
	public Student(){
		age=12;
	}
	
//	private void eat() {
//
//	}
}

public class TestFinal {

	
}
