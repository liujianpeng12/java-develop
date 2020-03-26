package com.mydemo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydemo.dao.EmpDao;
import com.mydemo.mapper.EmpMapper;
import com.mydemo.pojo.Emp;

public class MyTest2 {

	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
		
		EmpMapper empMapper = (EmpMapper)ctx.getBean("empMapper");
		List<Emp> emps = empMapper.selectList();
		for (Emp emp : emps) {
			System.out.println(emp.toString());
		}
	}
}
