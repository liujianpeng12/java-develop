package com.bean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知(Advice)
 * @author Administrator
 *
 */
public class ServiceBeanMethodBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("执行前置通知..");
		//throw new Exception("ss");
		
	}

}
