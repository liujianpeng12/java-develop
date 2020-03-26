package com.vince.db.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static Configuration cfg=null;
	private static SessionFactory factory=null;
	private static ServiceRegistry sr=null;
	
	static{
		cfg=new Configuration().configure();
		sr=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(sr);
	}
	
	public static void add(Object o){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(o);
		tx.commit();
		session.close();
	}
	
	public static Session getSession(){
		Session session=factory.openSession();
		return session;
	}
}
