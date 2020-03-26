package com.vince.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类
 * @author Administrator
 *
 */
public class JDKDyncProxyFactory implements InvocationHandler {
	
	private Object target=null;

	public Object createProxyInstance(Object target){
		this.target=target;
		//JDK提供Proxy类来创建动态代理对象
		//参数(目标对象的类加载器对象,目标对象实现的接口)
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("开始代理...");
		
		//调用被代理对象的方法
		Object result=method.invoke(target, args);
		
		System.out.println("结束代理...");
		return result;
	}
}
