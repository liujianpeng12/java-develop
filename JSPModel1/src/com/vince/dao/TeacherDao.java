package com.vince.dao;

import java.util.List;

import com.vince.model.Teacher;

public interface TeacherDao {
	
	boolean insert(Teacher t);
	
	boolean update(Teacher t);
	
	boolean delete(int id);
	
	List<Teacher> findAll();
	
	Teacher findById(int id);
}
