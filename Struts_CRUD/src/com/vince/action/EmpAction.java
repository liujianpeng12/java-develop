package com.vince.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

public class EmpAction extends ActionSupport implements RequestAware {

	private Emp emp;
	private int id;
	
	private Map<String,Object> request;
	private EmpDaoImpl dao=new EmpDaoImpl();
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String list(){
		List<Emp> list=dao.list();
		request.put("emps", list);
		return "list";
	}
	
	public String get(){
		emp=dao.get(id);
		return "update";
	}
	
	public String doAdd(){
		return "doAdd";
	}
	public String add(){
		dao.add(emp);
		return "list-action";
	}
	
	public String update(){
		dao.update(emp);
		return "list-action";
	}
	
	public String delete(){
		dao.delete(id);
		return "list-action";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}
}
