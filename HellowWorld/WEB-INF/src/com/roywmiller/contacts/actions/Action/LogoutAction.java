package com.roywmiller.contacts.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roywmiller.contacts.model.UserDatabase;

public class LogoutAction implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		UserDatabase.getSingleton().shutDown();
		return "/goodbye.jsp";
	}

}
