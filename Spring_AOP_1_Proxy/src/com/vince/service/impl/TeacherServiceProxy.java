package com.vince.service.impl;

import com.vince.service.TeacherService;

/**
 * teacher 代理类
 * @author Administrator
 *
 */
public class TeacherServiceProxy implements TeacherService {
	
	private TeacherService target=null;//要代理的目标对象
	
	public TeacherServiceProxy(TeacherService target){
		this.target=target;
	}

	@Override
	public void delete() {
		System.out.println("开始删除...");

		target.delete();
		
		System.out.println("结束删除...");
	}

}
