package com.jdbc.service.impl;

import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;
import com.jdbc.service.UserService;

public class UserServiceImpl2 implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) throws Exception {
		userDao.save(user);
		throw new RuntimeException("exception...");
	}

	@Override
	public void save2(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
