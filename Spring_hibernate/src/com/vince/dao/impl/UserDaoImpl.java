package com.vince.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.vince.dao.UserDao;
import com.vince.entity.User;

/**
 * 使用Spring提供的HibernateTemplate操作数据库
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void insert(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Override
	public void delete(int id) {
		User user=get(id);
		hibernateTemplate.delete(user);
	}

	@Override
	public User get(int id) {
		return (User) hibernateTemplate.get(User.class, id);
	}

	@Override
	public List<User> list() {
		return hibernateTemplate.find("from User");
	}

}
