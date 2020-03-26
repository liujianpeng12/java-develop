package com.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 自动扫描组件
 * 
 * 以注解的方式声明Bean的变量 
 * @Resource注解注入对象,默认按名称装配,也可以指定name属性来明确注入的bean * 
 * @Autowired注解,自动装配,默认按类型装配,
 * 如果要按名称装配,可以使用另外的注解@Qualifier("daoBeanXXX")
 * 
 * @author Administrator
 *
 */
@Service
public class ServiceBean {

	@Resource
	private DaoBean daoBean;
	
	@Autowired
	@Qualifier("daoBean2")
	private DaoBean2 daoBean2;
	
	//@Resource(name="daoBean") //也可以在setter方法中加注解
	public void setDaoBean(DaoBean daoBean) {
		System.out.println("setter装配...");
		this.daoBean = daoBean;
	}

	public void save(){
		daoBean.save();
		daoBean2.save();
		System.out.println("service bean save...");
	}
}
