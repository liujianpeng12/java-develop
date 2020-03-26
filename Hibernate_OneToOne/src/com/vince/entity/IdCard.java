package com.vince.entity;

public class IdCard {
	private int id;
	private String number;
	private Person person;
	
	public IdCard() {
		super();
	}
	public IdCard(String number) {
		super();
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", number=" + number + "]";
	}
	
}
