package com.vince.dao;

import java.util.List;

import com.vince.domain.Emp;

public interface EmpDao {
	
	boolean insert(Emp emp);
	
	boolean update(Emp emp);
	
	boolean delete(Emp emp);
	
	List<Emp> GetAll();
	
	Emp Get(int id);
	
	long GetCount();
}
