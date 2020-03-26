package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.ServiceBean;

public class TestAutowireBean {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		ServiceBean s=(ServiceBean)ctx.getBean("serviceBean");
		s.save();
	}
}
