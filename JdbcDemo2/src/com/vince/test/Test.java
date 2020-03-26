package com.vince.test;

import java.util.List;

import com.vince.dao.EmpDao;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.domain.Emp;

public class Test {

	public static void main(String[] args){
		Emp emp=new Emp(20,"Ãû×Ö2","Å®",40000,20);
		
		EmpDao empDao=new EmpDaoImpl();
		//empDao.insert(emp);
		//empDao.update(emp);
		//empDao.delete(emp);
		
		//List<Emp> emps=empDao.GetAll();
		//System.out.println(emps);
		
		Emp e=empDao.Get(1);
		System.out.println(e);
	}
}
