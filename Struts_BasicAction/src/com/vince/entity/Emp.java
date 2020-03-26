package com.vince.entity;

public class Emp {

	private int id;
	private String name;
	private int age;
	private float income;
	
	public Emp() {
		super();
	}
	
	public Emp(String name, int age, float income) {
		super();
		this.name = name;
		this.age = age;
		this.income = income;
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
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	
	
}
