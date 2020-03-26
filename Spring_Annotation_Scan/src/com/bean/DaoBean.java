package com.bean;

import org.springframework.stereotype.Repository;

@Repository
public class DaoBean {

	public void save(){
		System.out.println("dao bean 1 save...");
	}
}
