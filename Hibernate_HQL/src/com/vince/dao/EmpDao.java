package com.vince.dao;

import java.util.List;

import com.vince.entity.Emp;

public interface EmpDao {

	List<Emp> list();
	
	void add(Emp emp);
	
	List<Emp> list(int pageSize,int pageIndex);
	
	List<Emp> listByNameAge(String name,int age);
	
	Emp getEmp(int id);
	
	long getCount();
	
	Emp getById_QBC(int id);
}
