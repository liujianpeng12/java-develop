package com.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * @author Administrator
 *
 */
public class ServiceBeanMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result=null;
		System.out.println("环绕通知之前置通知...");
		
		try {
			result = invocation.proceed();
		} catch (Exception e) {
			System.out.println("环绕通知之异常通知...");
		}finally{
			System.out.println("环绕通知之最终通知...");
		}
		System.out.println("环绕通知之后置通知...");
		return result;
	}

}
