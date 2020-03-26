package com.vince.test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

public class HibernateHQLTest {
	
	EmpDaoImpl impl=null;
	
	@Before
	public void InitImpl(){
		impl=new EmpDaoImpl();
	}
	
	@Test
	public void add(){
		Emp emp=new Emp("小兴", 12, 4000);
		impl.add(emp);
	}
	
	@Test
	public void List() {
		List<Emp> list=impl.list();
		for(Emp emp:list){
			System.out.println(emp);
		}
	}

	@Test
	public void listPageing(){
		List<Emp> list=impl.list(2,2);
		for(Emp emp:list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void listByNameAge(){
		List<Emp> list=impl.listByNameAge("小兴", 12);
		for(Emp emp:list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void getEmp(){
		Emp emp=impl.getEmp(1);
		System.out.println(emp);
	}
	
	@Test
	public void getCount(){
		long c=impl.getCount();
		System.out.println(c);
	}
	
	@Test
	public void getById_QBC(){
		Emp emp=impl.getById_QBC(1);
		System.out.println(emp);
	}
}
