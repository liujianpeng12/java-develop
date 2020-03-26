package com.vince.action;

import com.opensymphony.xwork2.ActionSupport;

public class WildcardAction extends ActionSupport {
	
	public String list() throws Exception{
		return "list";		
	}
	
	public String add() throws Exception{
		return "add";		
	}
	
	public String delete() throws Exception{
		return "delete";		
	}
}
