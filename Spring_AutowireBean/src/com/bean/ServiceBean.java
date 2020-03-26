package com.bean;

public class ServiceBean {

	private DaoBean daoBean;
	
	public ServiceBean(DaoBean daoBean) {
		super();
		this.daoBean = daoBean;
		System.out.println("构造器 装配 1...");
	}
	public ServiceBean(DaoBean daoBean,DaoBean2 daoBean2) {
		super();
		this.daoBean = daoBean;
		System.out.println("构造器 装配  2...");
	}
	
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setter 装配");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		System.out.println("service saved...");
	}
}
