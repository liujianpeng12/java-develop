package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.ServiceBean;

/**
 * 前置通知,后置通知和一线通知
 * @author Administrator
 *
 */
public class AdviceTest {

	@Test
	public void test(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		//IServiceBean sb = (IServiceBean)ctx.getBean("proxyFactoryBean");//实现接口时,spring使用Proxy创建对象
		ServiceBean sb = (ServiceBean)ctx.getBean("proxyFactoryBean");//不实现接口时,spring使用cglib创建对象
		sb.query();
		System.out.println("--------------------");
		sb.add();
		System.out.println(sb.getClass());
	}
}
