package com.vince.model;

public class Friend {
	private int id;
	private String name;
	private int age;
	private String description;
	
	public Friend() {
		super();
	}
	public Friend(int id, String name, int age, String description) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.description = description;
	}
	public Friend(String name, int age, String description) {
		super();
		this.name = name;
		this.age = age;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
