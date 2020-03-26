package com.roywmiller.contacts.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BootstarpAction extends ContactsAction {

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) {
		return "/contactList.jsp";
	}

}
