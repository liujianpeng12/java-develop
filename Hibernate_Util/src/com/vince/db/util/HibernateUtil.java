package com.vince.db.util;

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
	private static Session session=null;
	
	static{
		cfg=new Configuration().configure();
		sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(sr);
	}
	
	public static SessionFactory GetSessionFactory(){
		return factory;
	}
	
	public static Session GetSession(){
		session=factory.openSession();
		return session;
	}
	
	public static void save(Object obj){
		session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
	}
}
