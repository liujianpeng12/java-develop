package com.vince.service;

import java.util.List;

import com.vince.entity.Student;

public interface StudentService {

	Student get(int id);
	List<Student> list();
	void add(Student s);
	void update(Student s);
	void delete(Student s);
}
