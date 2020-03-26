package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.ServiceBean;

public class TestAnnotation {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		ServiceBean b=(ServiceBean)ctx.getBean("serviceBean");
		b.save();
	}
}
