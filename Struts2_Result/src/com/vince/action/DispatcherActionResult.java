package com.vince.action;

import com.opensymphony.xwork2.ActionSupport;

public class DispatcherActionResult extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		return "dispatcher-success";
	}
}
