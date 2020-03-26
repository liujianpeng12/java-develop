package com.vince.entity;

public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String phone;
	
	public Student() {
		super();
	}

	public Student(String name, String sex, int age, String phone) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
