package com.vince.service.impl;

import java.util.List;

import com.vince.dao.StudentDao;
import com.vince.dao.impl.StudentDaoImpl;
import com.vince.entity.Student;
import com.vince.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao=new StudentDaoImpl();
	
	@Override
	public Student get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Student> list() {
		return dao.list();
	}

	@Override
	public void add(Student s) {
		dao.add(s);
	}

	@Override
	public void update(Student s) {
		dao.update(s);
	}

	@Override
	public void delete(Student s) {
		dao.delete(s);
	}

}
