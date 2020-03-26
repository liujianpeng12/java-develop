package com.vince.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String name;
	private Set<Teacher> teachers=new HashSet<Teacher>();
	
	public Student() {
		super();
	}
	public Student(String name) {
		super();
		this.name = name;
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
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
