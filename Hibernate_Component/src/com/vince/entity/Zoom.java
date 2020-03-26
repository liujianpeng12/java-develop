package com.vince.entity;

public class Zoom {
	private int id;
	private String name;
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Zoom [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
	
	
}
