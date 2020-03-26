package com.vince.db.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static Configuration cfg=null;
	private static ServiceRegistry rs=null;
	private static SessionFactory factory=null;
	
	static {
		cfg=new Configuration().configure();
		rs=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(rs);
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	
	public static Object get(Class clazz,Serializable id){
		Session session=factory.openSession();
		Object o=session.get(clazz, id);
		session.close();
		return o;
	}
	
	public static void save(Object o){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(o);
		tx.commit();
		session.close();
	}
	
	public static void update(Object o){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(o);
		tx.commit();
		session.close();
	}
	
	public static void delete(Object o){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
	}
}
