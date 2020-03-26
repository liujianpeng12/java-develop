package com.roywmiller.contacts.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roywmiller.contacts.model.Contact;
import com.roywmiller.contacts.model.ContactList;
import com.roywmiller.contacts.model.ContactsUser;


public class AddContactAction extends ContactsAction {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		Contact contact=createContact(request);
		
		HttpSession session=request.getSession();
		ContactsUser user=(ContactsUser)session.getAttribute("user");
		user.addContact(contact);
		session.setAttribute("user", user);
		return "/contactList.jsp";
	}
	
	protected Contact createContact(HttpServletRequest request)
	{
		Contact contact=new Contact();
		contact.setFirstName(request.getParameter(RequestParameters.FIRSTNAME));
		contact.setLastName(request.getParameter(RequestParameters.LASTNAME));
		contact.setStreet(request.getParameter(RequestParameters.STREET));
		contact.setCity(request.getParameter(RequestParameters.CITY));
		contact.setState(request.getParameter(RequestParameters.STATE));
		contact.setZip(request.getParameter(RequestParameters.ZIP));
		contact.setType(request.getParameter(RequestParameters.TYPE));
		return contact;
	}
}
