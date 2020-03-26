package com.vince.entity;

public class Address {
	private int id;
	private String location;
	private String number;
	
	
	public Address() {
		super();
	}
	public Address(String location, String number) {
		super();
		this.location = location;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", number="
				+ number + "]";
	}
	
	
	
}
