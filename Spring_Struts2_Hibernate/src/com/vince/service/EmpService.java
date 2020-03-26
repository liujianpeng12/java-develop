package com.vince.service;

import java.util.List;

import com.vince.entity.Emp;

public interface EmpService {

	void add(Emp emp) throws RuntimeException;
	
	void modify(Emp emp) throws RuntimeException;
	
	void remove(int id) throws RuntimeException;
	
	Emp get(int id) throws RuntimeException;
	
	List<Emp> list() throws RuntimeException;
}
