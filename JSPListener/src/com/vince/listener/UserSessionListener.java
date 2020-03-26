package com.vince.listener;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserSessionListener
 *
 */
@WebListener
public class UserSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
    	System.out.println("sessionDestroyed...");
    	
    	List<String> users=(List<String>)se.getSession().getServletContext().getAttribute("online");
    	String name=se.getSession().getAttribute("userName").toString();
    	users.remove(name);
    }
	
}
