package com.mydemo.dao;

import java.util.List;

import com.mydemo.pojo.Emp;


public interface EmpDao {

	List<Emp> selectList();
	
	Emp getEmp(int id);
	
	void addEmp(Emp emp);
	
	void updateEmp(Emp emp);
	
	void deleteEmp(int id);
}
