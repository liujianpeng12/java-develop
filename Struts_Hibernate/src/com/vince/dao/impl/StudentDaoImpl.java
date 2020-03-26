package com.vince.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vince.dao.StudentDao;
import com.vince.db.util.HibernateUtil;
import com.vince.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student get(int id) {
		return (Student)HibernateUtil.get(Student.class, id);
	}

	@Override
	public List<Student> list() {
		String hql="from Student";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		List<Student> list=(List<Student>)query.list();
		session.close();
		return list;
	}

	@Override
	public void add(Student s) {
		HibernateUtil.save(s);
	}

	@Override
	public void update(Student s) {
		HibernateUtil.update(s);
	}

	@Override
	public void delete(Student s) {
		HibernateUtil.delete(s);
	}

}
