package com.vince.object;

class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 重写equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(this==obj)return true;
		//判断两个对象是否为同一类型
		if(this.getClass()==obj.getClass()){
			Person p=(Person)obj;
			if(p.getAge()==this.getAge()&& p.getName().equals(this.getName())){
				return true;
			}
		}		
		return false;
	}
}

public class Test {

	public static void main(String[] args){
		String s1=new String("hello");
		String s2="hello";
		System.out.println(s1.equals(s2));
		
		System.out.println("---------------");
		Person p1=new Person("abc",12);
		Person p2=new Person("abc",12);
		System.out.println(p1.equals(p2));
	}
}
