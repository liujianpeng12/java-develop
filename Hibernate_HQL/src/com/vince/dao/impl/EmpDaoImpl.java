package com.vince.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.vince.dao.EmpDao;
import com.vince.db.util.HibernateUtil;
import com.vince.entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Emp> list() {
		String hql = "from Emp";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Emp> list = query.list();
		session.close();
		return list;
	}

	@Override
	public void add(Emp emp) {
		HibernateUtil.add(emp);
	}

	@Override
	public List<Emp> list(int pageSize, int pageIndex) {
		String hql="from Emp";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Emp> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<Emp> listByNameAge(String name, int age) {
		String hql="from Emp where name=:name and age=:age";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setString("name", name);
		query.setInteger("age", age);
		List<Emp> list=query.list();
		session.close();
		return list;
	}

	@Override
	public Emp getEmp(int id) {
		String hql="from Emp where id=:id";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		query.setInteger("id", id);
		//查询的对象唯一时
		Emp emp=(Emp) query.uniqueResult();
		session.close();
		return emp;
	}

	@Override
	public long getCount() {
		String hql="select count(id) from Emp";
		Session session=HibernateUtil.getSession();
		Query query=session.createQuery(hql);
		long c=(long) query.uniqueResult();
		session.close();
		return c;
	}

	/**
	 * QBC查询,作为了解即可
	 */
	@Override
	public Emp getById_QBC(int id) {
		Session session=HibernateUtil.getSession();
		Criteria criteria=session.createCriteria(Emp.class);
		//添加查询条件
		criteria.add(Restrictions.eq("id", id));
		Emp emp=(Emp) criteria.uniqueResult();
		session.close();
		return emp;
	}

	
	
}
