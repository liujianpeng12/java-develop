package com.roywmiller.contacts.model;
import java.util.UUID; 
public class Contact implements java.io.Serializable{
	public Contact()
	{
		 UUID uuid = UUID.randomUUID(); 
		 id=uuid.toString();
	}
	
	private String id;
	public String getId(){
		return id;
	}
	public void setId(String v){
		id=v;
	}
	
	private String firstName;
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String v){
		firstName=v;
	}
	
	private String lastName;
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String v){
		lastName=v;
	}
	
	private String street;
	public String getStreet(){
		return street;
	}
	public void setStreet(String v){
		street=v;
	}
	
	private String city;
	public String getCity(){
		return city;
	}
	public void setCity(String v){
		city=v;
	}
	
	private String state;
	public String getState(){
		return state;
	}
	public void setState(String v){
		state=v;
	}
	
	private String zip;
	public String getZip(){
		return zip;
	}
	public void setZip(String v){
		zip=v;
	}
	
	private String type;
	public String getType(){
		return type;
	}
	public void setType(String v){
		type=v;
	}
}
