package com.roywmiller.contacts.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactList {
	static List list=new ArrayList();
	
	public static List getContacts()
	{
		return list;
	}
	
	public static void addContact(Contact contact)
	{
		list.add(contact);
	}
	
	public static void removeContact(String contactId)
	{
		if(list.size()>0)
		{
			for(Iterator i=list.iterator();i.hasNext();)
			{
				 Contact contact = (Contact)i.next();
				 if(contact.getId().equals(contactId))
				 {
					 list.remove(contact);
					 break;
				 }
			}
		}
	}
}
