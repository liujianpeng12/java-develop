package com.vince.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Zoom;

/**
 * Hibernate使用 Ehcache 缓存组件 数据库的隔离机制需要了解
 * 
 * @author Administrator
 *
 */

public class ComponentTest {

	@Test
	public void add() {
		Zoom z = new Zoom("上海公园");
		HibernateUtil.add(z);
	}

	@Test
	public void getZoom() {
		Session session = HibernateUtil.getSession();
		Zoom z = (Zoom) session.get(Zoom.class, 1);
		System.out.println(z);
		session.close();

		// 下面再查询时不会再查询数据库而是查询缓存(不会再发送SQL语句)
		session = HibernateUtil.getSession();
		z = (Zoom) session.get(Zoom.class, 1);
		System.out.println(z);
		session.close();
	}

	@Test
	public void GetZoomByHQL() {
		String hql = "from Zoom";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//需要设置可缓存 
		query.setCacheable(true);
		List<Zoom> list = query.list();
		for (Zoom z : list) {
			System.out.println(z);
		}
		session.close();

		session = HibernateUtil.getSession();
		query = session.createQuery(hql);
		//需要设置可缓存 
		query.setCacheable(true);
		list = query.list();
		for (Zoom z : list) {
			System.out.println(z);
		}
		session.close();
	}
}
