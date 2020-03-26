package com.vince.domain;

public class Emp {
	private int id;
	private String name;
	private String gender;
	private float salary;
	private int age;
	
	public Emp() {
		super();
	}
	public Emp(int id, String name, String gender, float salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.age = age;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", salary=" + salary + ", age=" + age + "]";
	}
	
}
