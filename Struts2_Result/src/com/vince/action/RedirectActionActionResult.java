package com.vince.action;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectActionActionResult extends ActionSupport {

	@Override
	public String execute() throws Exception {
		return "redirectAction-success";
	}
}
