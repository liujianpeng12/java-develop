package com.vince.dao;

import java.util.List;

import com.vince.model.Friend;

public interface FriendDao {

	boolean insert(Friend f);
	
	boolean update(Friend f);
	
	boolean delete(int id);
	
	List<Friend> findAll();
	
	Friend findById(int id);
}
