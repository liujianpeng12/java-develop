package com.roywmiller.contacts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContactsUser implements java.io.Serializable  {

	protected String username="";
	protected String password="";
	protected List contactList=new ArrayList();
	
	public ContactsUser(){
		
	}
	
	public ContactsUser(String username,String password,List contactList){
		this.username=username;
		this.password=password;
		this.contactList.addAll(contactList);		
	}
	
	public List getContacts()
	{
		return contactList;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public boolean hasContacts()
	{
		return !contactList.isEmpty();
	}
	
	public void addContact(Contact contact){
		contactList.add(contact);
	}
	
	public void removeContact(Contact contact)
	{
		contactList.remove(contact);
	}
	
	public void removeContact(String id)
	{
		if(contactList.size()>0)
		{
			for(Iterator i=contactList.iterator();i.hasNext();)
			{
				Contact contact=(Contact)i.next();
				System.out.println(contact.getId());		
				if(contact.getId()==id)
				{
					contactList.remove(contact);
					break;
				}
			}
		}
	}
}
