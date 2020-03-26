package com.vince.model;

public class Teacher {
	private int tid;
	private String name;
	private String description;
	private int age;
	public Teacher() {
		super();
	}
	public Teacher(String name, String description, int age) {
		super();
		this.name = name;
		this.description = description;
		this.age = age;
	}
	public Teacher(int tid, String name, String description, int age) {
		super();
		this.tid = tid;
		this.name = name;
		this.description = description;
		this.age = age;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
