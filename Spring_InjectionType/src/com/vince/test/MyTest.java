package com.vince.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.service.Animal;

public class MyTest {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Animal ani=(Animal)ctx.getBean("animalService");
		ani.call();
	}
}
