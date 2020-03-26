package com.vince.entity;

public class Emp {

	private int id;
	private String name;
	private int age;
	private float salary;
	public Emp() {
	}
	public Emp(String name, int age, float salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Emp(int id, String name, int age, float salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	
}
