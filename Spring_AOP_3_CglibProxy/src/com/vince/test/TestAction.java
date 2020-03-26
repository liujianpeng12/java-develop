package com.vince.test;

import org.junit.Test;

import com.vince.service.ClassesService;
import com.vince.service.StudentService;
import com.vince.service.TeacherService;
import com.vince.service.impl.CglibProxyFactory;
import com.vince.service.impl.StudentServiceImpl;
import com.vince.service.impl.TeacherServiceImpl;

/**
 * AOP实现之Cglib实现动态代理
 * @author Administrator
 *
 */
public class TestAction {

	@Test
	public void test(){
		CglibProxyFactory factory=new CglibProxyFactory();
		
		StudentService ss=new  StudentServiceImpl();		
		StudentService ssp=(StudentService)factory.createProxyInstance(ss);
		ssp.delete();
		
		System.out.println();
		
		TeacherService ts=new TeacherServiceImpl();
		TeacherService tsp=(TeacherService)factory.createProxyInstance(ts);
		tsp.delete();
		
		System.out.println();
		
		//不使用接口
		ClassesService cs=new ClassesService();
		ClassesService csp=(ClassesService)factory.createProxyInstance(cs);
		csp.find();
	}
	
}
