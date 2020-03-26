package com.roywmiller.contacts.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roywmiller.contacts.model.ContactList;
import com.roywmiller.contacts.model.ContactsUser;


public class RemoveContactAction extends ContactsAction {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		String contactId=request.getParameter("id");
		
		HttpSession session=request.getSession();
		ContactsUser user=(ContactsUser)session.getAttribute("user");
		user.removeContact(contactId);
		session.setAttribute("user", user);
		return "/contactList.jsp";
	}

}
