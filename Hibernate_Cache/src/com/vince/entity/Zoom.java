package com.vince.entity;

public class Zoom {
	private int id;
	private String name;
	
	public Zoom() {
		super();
	}
	public Zoom(String name) {
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
	@Override
	public String toString() {
		return "Zoom [id=" + id + ", name=" + name 
				+ "]";
	}
	
	
	
	
}
