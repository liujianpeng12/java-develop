package com.vince.dao;

import java.util.List;

import com.vince.entity.Emp;

public interface EmpDao {
	
	List<Emp> list();
	
	Emp get(int id);
	
	boolean add(Emp emp);
	
	boolean update(Emp emp);
	
	boolean delete(int id);
}
