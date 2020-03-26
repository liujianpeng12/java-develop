package com.vince.test;

import org.junit.Test;

import com.vince.service.StudentService;
import com.vince.service.TeacherService;
import com.vince.service.impl.JDKDyncProxyFactory;
import com.vince.service.impl.StudentServiceImpl;
import com.vince.service.impl.TeacherServiceImpl;

/**
 * AOP实现之动态代理模式
 * @author Administrator
 *
 */
public class TestAction {

	@Test
	public void test(){
		JDKDyncProxyFactory factory=new JDKDyncProxyFactory();
		
		StudentService ss=new  StudentServiceImpl();		
		StudentService ssp=(StudentService)factory.createProxyInstance(ss);
		ssp.delete();
		
		System.out.println();
		
		TeacherService ts=new TeacherServiceImpl();
		TeacherService tsp=(TeacherService)factory.createProxyInstance(ts);
		tsp.delete();
	}
	
}
