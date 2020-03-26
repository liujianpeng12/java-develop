package com.bean;


public class ServiceBean {

	private DaoBean daoBean;	
	
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setter×°Åä...");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		System.out.println("service bean save...");
	}
}
