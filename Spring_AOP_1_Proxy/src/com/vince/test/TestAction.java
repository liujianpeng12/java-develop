package com.vince.test;

import org.junit.Test;

import com.vince.service.StudentService;
import com.vince.service.TeacherService;
import com.vince.service.impl.StudentServiceImpl;
import com.vince.service.impl.StudentServiceProxy;
import com.vince.service.impl.TeacherServiceImpl;
import com.vince.service.impl.TeacherServiceProxy;

/**
 * AOP实现之静态代理模式
 * @author Administrator
 *
 */
public class TestAction {

	@Test
	public void test(){
		StudentService ss=new StudentServiceImpl();
		StudentServiceProxy sp=new StudentServiceProxy(ss);
		sp.delete();
		
		System.out.println();
		
		TeacherService ts=new TeacherServiceImpl();
		TeacherServiceProxy tp=new TeacherServiceProxy(ts);
		tp.delete();
	}
	
}
