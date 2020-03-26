package com.vince.service.impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory {

	public Object createProxyInstance(final Object target){
		Enhancer enhancer=new Enhancer(); 
		
		//指定目标对象作为代理对象的父类
		enhancer.setSuperclass(target.getClass());
		//定义回调方法
		Callback callback=new MethodInterceptor() {
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2,
					MethodProxy arg3) throws Throwable {
				System.out.println("cglib proxy begin...");
				
				Object result = arg1.invoke(target, arg2);
				
				System.out.println("cglib proxy end...");
				
				return result;
			}
		};
		//设置回调方法
		enhancer.setCallback(callback);
		//创建代理对象并返回
		return enhancer.create();
	}
}
