package com.jdbc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;

public class UserDaoHibernateImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) throws SQLException {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) throws SQLException {
		hibernateTemplate.update(user);
	}

	@Override
	public List<User> list() throws SQLException {
		List<User> list = hibernateTemplate.find("from User");
		return list;
	}

	@Override
	public void delete(int id) throws SQLException {
		User user = new User(id,"aa",11);
		hibernateTemplate.delete(user);
	}

	@Override
	public User findById(int id) throws SQLException {
		return (User)hibernateTemplate.get(User.class, id);
	}

}
