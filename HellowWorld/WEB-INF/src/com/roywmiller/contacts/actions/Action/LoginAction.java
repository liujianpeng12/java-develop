package com.roywmiller.contacts.actions.Action;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roywmiller.contacts.model.ContactsUser;
import com.roywmiller.contacts.model.UserDatabase;

public class LoginAction implements Action {

	@Override
	public String perform(HttpServletRequest request,
			HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		ContactsUser user=UserDatabase.getSingleton().get(username, password);
		if(null!=user)
		{
			System.out.println(new Random().nextInt());
			String str=""+request.getScheme();
			request.getSession().setAttribute("user", user);
			return "/contactList.jsp";
		}else
		{
			request.getSession().setAttribute("errorMessage", "Invalid username/password");
			return "/error.jsp";
		}
	}

}
