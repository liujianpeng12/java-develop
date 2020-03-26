package com.service.impl;

import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void query() {
		System.out.println("查询用户...");
		
	}

	@Override
	public void add() throws RuntimeException {
		System.out.println("添加用户...");
		throw new RuntimeException("出现异常");
	}

	@Override
	public void update() {
		System.out.println("更新用户...");
	}

}
