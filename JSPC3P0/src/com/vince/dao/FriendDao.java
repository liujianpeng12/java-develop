package com.vince.dao;

import java.util.List;

import com.vince.model.Friend;
import com.vince.model.PageRoll;

public interface FriendDao {

	boolean insert(Friend f);
	
	boolean update(Friend f);
	
	boolean delete(int id);
	
	List<Friend> findAll();
	
	Friend findById(int id);
	
	List<Friend> list(PageRoll pageRoll);
}
