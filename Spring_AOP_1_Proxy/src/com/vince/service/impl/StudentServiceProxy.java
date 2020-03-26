package com.vince.service.impl;

import com.vince.service.StudentService;

/**
 *  Student 代理类
 * @author Administrator
 *
 */
public class StudentServiceProxy implements StudentService {
	
	private StudentService target=null;//要代理的对象
	
	public StudentServiceProxy(StudentService target){
		this.target=target;
	}

	@Override
	public void delete() {
		System.out.println("开始删除...");

		target.delete();
		
		System.out.println("结束删除...");
	}

}
