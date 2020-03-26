package com.vince.exception;

import com.opensymphony.xwork2.ActionSupport;

public class ExceptionAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		throw new RuntimeException();
	}
}
