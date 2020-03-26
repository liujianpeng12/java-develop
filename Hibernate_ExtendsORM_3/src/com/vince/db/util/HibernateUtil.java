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
	private static ServiceRegistry sr=null;
	private static SessionFactory factory=null;
	
	static{
		cfg=new Configuration().configure();
		sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(sr);
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	public static Session getSession(){
		Session session=factory.openSession();
		return session;
	}
	
	public static Object get(Class clazz,Serializable id){
		Session session=getSession();
		Object o=session.get(clazz, id);
		session.close();
		return o;
	}
	
	public static void add(Object o){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(o);
		tx.commit();
		session.close();
	}
	
	public static void update(Object o){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.update(o);
		tx.commit();
		session.close();
	}
	
	public static void delete(Object o){
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
	}
}
