package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

/**
 * 以注解方式配置AOP
 * @author Administrator
 *
 */
public class AdviceTest {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserService us=(UserService)ctx.getBean("userService");
		us.query();
	}
	
	@Test
	public void thorwsAspectTest(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserService us=(UserService)ctx.getBean("userService");
		us.add();
	}
}
