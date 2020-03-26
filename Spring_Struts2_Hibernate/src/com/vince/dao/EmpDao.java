package com.vince.dao;

import java.sql.SQLException;
import java.util.List;

import com.vince.entity.Emp;

public interface EmpDao {

	void insert(Emp emp) throws SQLException;
	
	void update(Emp emp) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	Emp select(int id) throws SQLException;
	
	List<Emp> list() throws SQLException;
}
