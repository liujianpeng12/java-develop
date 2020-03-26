package com.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.dao.EmpDao;
import com.vince.entity.Emp;
import com.vince.service.EmpService;

public class Test {
	ApplicationContext ctx = null;
	EmpDao dao;
	EmpService empService;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (EmpDao) ctx.getBean("empDao");
		empService=(EmpService)ctx.getBean("empService");
	}

	@org.junit.Test
	public void testInsert() throws SQLException {
		Emp emp = new Emp("–°¡÷", 21, 5000);
		dao.insert(emp);
	}
	
	@org.junit.Test
	public void testSelect() throws SQLException {
		Emp emp = dao.select(1);
		System.out.println(emp);
	}
	
	@org.junit.Test
	public void testList() throws SQLException {
		List<Emp> list = dao.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}		
	}
	
	@org.junit.Test
	public void testAdd() throws SQLException {
		Emp emp = new Emp("–°µ≠", 21, 5000);
		empService.add(emp);
	}
}
