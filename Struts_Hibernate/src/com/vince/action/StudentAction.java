package com.vince.action;

import java.util.List;

import com.vince.entity.Student;
import com.vince.service.StudentService;
import com.vince.service.impl.StudentServiceImpl;

public class StudentAction extends BasicAction<Student> {

	private StudentService serv=new StudentServiceImpl();
	
	public void prepareGet(){
		System.out.println("id="+id);
		model=serv.get(id);
	}
	public String get(){		
		return "update";
	}
	
	public String list(){
		List<Student> list=serv.list();
		request.put("list", list);
		return "list";
	}
	
	public String doAdd(){
		return "doAdd";
	}
	public void prepareAdd(){
		model=new Student();
	}
	public String add(){
		serv.add(model);
		return "list-action";
	}
	
	public void prepareUpdate(){
		model=new Student();
	}
	public String update(){
		serv.update(model);
		return "list-action";
	}
	
	public void prepareDelete(){
		model=new Student();
	}
	public String delete(){
		serv.delete(model);
		return "list-action";
	}
}
