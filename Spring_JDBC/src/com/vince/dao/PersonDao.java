package com.vince.dao;

import java.util.List;

import com.vince.entity.Person;

public interface PersonDao {

	void add(Person p);
	
	int insert(Person p);
	
	void update(Person p);
	
	void delete(int id);
	
	Person get(int id);
	
	List<Person> list();
}
