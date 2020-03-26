package com.vince.text;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vince.entity.Student;

public class HelloHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student("ÕÅÃ÷", "ÄÐ", 14, "13298899992");
		//
		Configuration cfg=new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory=cfg.buildSessionFactory(sr);
//		SessionFactory factory=cfg.buildSessionFactory(
//				new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		session.save(stu);
		tx.commit();
		session.close();
		//factory.close();
	}

}
