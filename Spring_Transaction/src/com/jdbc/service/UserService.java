package com.jdbc.service;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.entity.User;

public interface UserService {
	public void save(User user) throws Exception;
	public void save2(User user) throws Exception;

	public void update(User user) throws Exception;

	public List<User> list() throws Exception;

	public void delete(int id) throws Exception;

	public User findById(int id) throws Exception;
}
