package com.vince.text;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Student;

public class HelloHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("黄化", "男", 24, "13298899992");
		//
		//HibernateUtil.save(stu);
		
		
		//get();
		//load();
		
		save(stu);
		//persist(stu);
		//persist2(stu);

		//update();
		//update2();
		//update3();
		
		//delete();
	}
	
	/**
	 * Hibernate 数据对象的状态:临时状态,持久化状态,游离状态
	 */
	
	/**
	 * 查询:如果有相应的对象则返回数据对象,如果没有则返回null
	 */
	private static void get(){
		Session session=HibernateUtil.GetSession();
		Student s=(Student)session.get(Student.class, 3);
		session.close();
		System.out.println(s);
	}
	
	/**
	 * 使用load方法查询:返回的只是 一个代理,而不会去查询数据库,当使用该代理对象时才会去查询数据库;
	 * 当使用该代理对象时,若查询数据库有数据则返回数据对象,否则抛出异常
	 */
	private static void load(){
		Session session=HibernateUtil.GetSession();
		Student s=(Student)session.load(Student.class,3);
		System.out.println(s);
		session.close();
	}
	
	/**
	 * 添加
	 * @param s
	 */
	private static void save(Student s){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
	}

	/**
	 * 添加:persist 方法在Transaction中执行时,数据对象(Student)的主键会自动填充到对象中,与save方法一样
	 * @param s
	 */
	private static void persist(Student s){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.persist(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * 添加:persist 方法不在Transaction中执行时,再调用 flush方法后,主要会填充值,但是数据对象(Student)不会添加到数据库
	 * @param s
	 */
	private static void persist2(Student s){
		Session session=HibernateUtil.GetSession();
		session.persist(s);
		session.flush();
		session.close();
	}
	
	/**
	 * 通过临时数据对象(new方式创建)无法更新
	 */
	private static void update(){
		Student s=new Student(4,"陈明", "男", 24, "13298899992");
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * 通过主键从数据库查询得到对象,再更新到数据库
	 */
	private static void update2(){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		Student s=(Student)session.get(Student.class, 3);
		s.setName("小明");
		s.setAge(21);
		s.setPhone("45333333");
		s.setSex("男");
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * 通过在配置文件中配置[dynamic-update="true"],则只会更新设置了的属性
	 */
	private static void update3(){
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		Student s=(Student)session.get(Student.class, 4);
		s.setName("小淡");
		session.update(s);
		tx.commit();
		session.close();
	}
	
	/**
	 * 删除:若属性设置为非空,则必须填充该属性才能删除,填充什么值都可以
	 * 若数据库中找不到要删除的记录则抛出异常
	 */
	private static void delete(){
		Student s=new Student();
		s.setId(11);
		s.setName("www");
		Session session=HibernateUtil.GetSession();
		Transaction tx=session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();
	}
}
