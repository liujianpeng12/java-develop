package com.vince.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringControler {

	@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		String message="Hello world,Spring 2.5 !";
		System.out.println(message);
		return new ModelAndView("hello", "message", message);
	}
	
}
