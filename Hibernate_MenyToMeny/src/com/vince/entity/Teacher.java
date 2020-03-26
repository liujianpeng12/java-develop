package com.vince.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int id;
	private String name;
	private int age;
	private Set<Student> students=new HashSet<Student>();
	
	public Teacher() {
		super();
	}
	public Teacher(String name, int age) {
		super();
		this.name = name;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
