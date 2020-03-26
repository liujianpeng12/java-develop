package com.vince.entity;

/**
 * 继承关系映射-根类映射一个表(只生成一个表)
 * @author Administrator
 *
 */
public class Animal {
	private int id;
	private String name;
	private int age;
	
	
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
	
	
}
