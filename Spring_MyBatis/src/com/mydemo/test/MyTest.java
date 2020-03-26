package com.mydemo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydemo.dao.EmpDao;
import com.mydemo.pojo.Emp;

public class MyTest {

	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext.xml");
		
		EmpDao empDao = (EmpDao)ctx.getBean("empDao");
		List<Emp> emps = empDao.selectList();
		for (Emp emp : emps) {
			System.out.println(emp.toString());
		}
	}
}
