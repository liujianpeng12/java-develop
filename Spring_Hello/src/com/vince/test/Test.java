package com.vince.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.service.AnimalService;



public class Test {

	@org.junit.Test
	public void test1(){

		//º”‘ÿ≈‰÷√
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		AnimalService serv=(AnimalService)ctx.getBean("animalService");
		serv.call();
	}
}
