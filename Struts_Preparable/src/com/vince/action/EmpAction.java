package com.vince.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.entity.Emp;

/**
 * Prepareable拦截器
 * 1.在执行具体的业务方法之前该拦截器为我们准备对象
 * 2.使用该拦截器为每个具体的业务方法写一个准备对象的方法,方法名为prepare或prepareDo前缀加上具体的业务方法名,且首字母大写
 * 3.在struts.xml文件不配置使用paramsPrepareParamsStack拦截器栈,目的是为在执行准备之前先执行param拦截器为栈顶对象赋值
 * paramsPrepareParamsStack拦截器的执行顺序是：
 * parmas-->prepare-->modelDriven-->params
 * @author Administrator
 *
 */
public class EmpAction extends ActionSupport implements RequestAware,ModelDriven<Emp>,Preparable {

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
	
	/**
	 * 为获取方法准备对象
	 */
	public void prepareGet(){
		System.out.println("prepareGet...");
		emp=dao.get(id);
	}
	public String get(){
		return "update";
	}
	
	public String doAdd(){
		return "doAdd";
	}
	
	/**
	 * 为添加方法准备对象
	 */
	public void prepareAdd(){
		System.out.println("prepareAdd...");
		emp=new Emp();
	}
	public String add(){
		dao.add(emp);
		return "list-action";
	}
	
	/**
	 * 为修改方法准备对象
	 */
	public void prepareUpdate(){
		System.out.println("prepareUpdate...");
		emp=new Emp();
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
	
	/**
	 * ModelDrivern接口的方法
	 */
	@Override
	public Emp getModel() {
		//System.out.println("getModel...");
		//emp=new Emp();
		return emp;
	}
	
	/**
	 * Preparable接口的方法
	 */
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
