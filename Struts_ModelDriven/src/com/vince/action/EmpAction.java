package com.vince.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

/**
 * ModelDriven拦截器
 * 1.在Action中实现 ModelDriven接口
 * 2.实现 getModel方法,返回一个对象,struts会调用该方法把返回的对象压入栈顶
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport implements RequestAware,ModelDriven<Emp> {

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
		Emp e=dao.get(emp.getId());
		emp.setId(e.getId());
		emp.setName(e.getName());
		emp.setAge(e.getAge());
		emp.setIncome(e.getIncome());
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
		dao.delete(emp.getId());
		return "list-action";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}
	@Override
	public Emp getModel() {
		System.out.println("getModel...");
		emp=new Emp();
		return emp;
	}
}
