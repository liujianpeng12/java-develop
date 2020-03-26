package com.vince.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BasicAction<T> extends ActionSupport implements RequestAware,ModelDriven<T>,Preparable {

	protected Map<String, Object> request;
	protected T model;
	protected int id;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}

}
