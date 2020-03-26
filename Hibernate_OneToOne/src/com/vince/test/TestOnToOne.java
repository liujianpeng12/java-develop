package com.vince.test;


import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.IdCard;
import com.vince.entity.Person;

public class TestOnToOne {
	
	/**
	 * 关联关系映射-- 一对一共享主键方式:
	 * Person为主对象,IdCard为从对象,从对象id参考主对象的id,即从对象的id与主对象的id一样
	 */
	
	@Test
	public void add(){
		Person p=new Person("小中", 23);		
		IdCard idCard=new IdCard("12345678990");
		
		p.setIdCard(idCard);
		idCard.setPerson(p);
		
		HibernateUtil.add(p);
		//在主对象中配置[ cascade="all"]时就不需要手动插入从对象,否则需要手动插入从对象,如下语句
		//HibernateUtil.add(idCard);
	}
	
	@Test
	public void getPerson(){
		Session session=HibernateUtil.getSession();
		//一对一关联时,当查询主对象Person的同时使用join查询从对象IdCard
		Person p=(Person) session.get(Person.class, 3);
		session.close();
		//发送一句查询语句
		System.out.println(p);
		//不会再发送查询语句
		System.out.println(p.getIdCard());
	}
	
	@Test
	public void getIdCard(){
		Session session=HibernateUtil.getSession();
		//一对一关联时,当查询从对象IdCard时不会同时查询主对象Person
		IdCard c=(IdCard) session.get(IdCard.class, 3);
		
		//发送一句查询语句
		System.out.println(c);
		//会再发送查询语句
		System.out.println(c.getPerson());
		
		session.close();
	}
}
