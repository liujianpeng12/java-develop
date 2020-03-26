package com.vince.test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.User;

public class TestC3P0 {
	
	/**
	 * C3P0
	 * 
	 */
	
	@Test
	public void add(){
		User user=new User("ะกริ", 23);	
		HibernateUtil.add(user);
	}
	
	@Test
	public void getUser(){
		Session session=HibernateUtil.getSession();
		User u=(User) session.get(User.class, 3);
		
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
					System.out.println(connection.getClass());
			}
		});
		
		session.close();
		
		System.out.println(u);
	}
}
