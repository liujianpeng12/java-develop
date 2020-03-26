package com.vince.service.impl;

import com.vince.dao.BeanDao;
import com.vince.dao.LogDao;
import com.vince.service.Animal;

public class Dog implements Animal {

	private BeanDao dao=null;
	private LogDao logDao=null;
		
	/**
	 * 构造器注入,调用此构造方法
	 * @param logDao
	 */
	public Dog(LogDao logDao) {
		super();
		this.logDao = logDao;
	}

	/**
	 * setter注入,调用此方法
	 * @param dao
	 */
	public void setDao(BeanDao dao) {
		this.dao = dao;
	}

	@Override
	public void call() {
		dao.add();
		logDao.insert();
		System.out.println("小狗叫...");
	}

}
