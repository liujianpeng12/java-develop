package com.jdbc.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.entity.User;
import com.jdbc.service.UserService;

public class Test2 {

	ApplicationContext ctx=null;
	UserService us=null;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		us=(UserService)ctx.getBean("userService2");
	}
	
	@org.junit.Test
	public void save() throws Exception{
		User user=new User("Tomer456",22);
		us.save(user);
	}
}
