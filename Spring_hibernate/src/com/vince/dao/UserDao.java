package com.vince.dao;

import java.util.List;

import com.vince.entity.User;

public interface UserDao {

	void insert(User user);
	
	void update(User user);
	
	void delete(int id);
	
	User get(int id);
	
	List<User> list();
}
