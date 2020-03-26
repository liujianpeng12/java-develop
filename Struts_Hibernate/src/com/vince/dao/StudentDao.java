package com.vince.dao;

import java.util.List;

import com.vince.entity.Student;

public interface StudentDao {

	Student get(int id);
	List<Student> list();
	
	void add(Student s);
	void update(Student s);
	void delete(Student s);
}
