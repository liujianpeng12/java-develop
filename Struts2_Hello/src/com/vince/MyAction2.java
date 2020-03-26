package com.vince;

import com.opensymphony.xwork2.Action;

public class MyAction2 implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("MyAction2");
		return "success";
	}

}
