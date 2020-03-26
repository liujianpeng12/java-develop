package com.vince.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vince.dao.EmpDao;
import com.vince.entity.Emp;

public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao  {

	@Override
	public void insert(Emp emp) throws SQLException {
		getHibernateTemplate().save(emp);
	}

	@Override
	public void update(Emp emp) throws SQLException {
		getHibernateTemplate().update(emp);
	}

	@Override
	public void delete(int id) throws SQLException {
		Emp emp=new Emp(id, "", 0, 0);
		getHibernateTemplate().delete(emp);
	}

	@Override
	public Emp select(int id) throws SQLException {
		return (Emp)getHibernateTemplate().load(Emp.class, id);//load方法会延迟加载,需要配置
		//return (Emp)getHibernateTemplate().get(Emp.class, id);//get方法非延迟加载
	}

	@Override
	public List<Emp> list() throws SQLException {
		return (List<Emp>)getHibernateTemplate().find("from Emp");
	}

}
