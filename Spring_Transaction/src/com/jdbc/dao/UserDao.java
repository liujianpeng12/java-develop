package com.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.entity.User;

public interface UserDao {

	public void save(User user) throws SQLException;

	public void update(User user) throws SQLException;

	public List<User> list() throws SQLException;

	public void delete(int id) throws SQLException;

	public User findById(int id) throws SQLException;
}
