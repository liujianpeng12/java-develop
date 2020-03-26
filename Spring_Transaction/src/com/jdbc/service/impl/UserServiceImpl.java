package com.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;
import com.jdbc.service.UserService;

/**
 * Spring事务管理中使用注解
 * 
 * Transactional:注解表示配置事务管理
 * propagation:表示设置事务的传播方式,默认是REQUIRED(业务在一个事务中执行)
 * 事务默认提交方式:如果方法执行时没有抛出运行时异常(RuntimeException),则事务被提交,否则事务回滚
 * 可以设置rollbackFor属性指定事务回滚的异常
 * 也可以设置noRollbackFor属性指定事务不回滚的异常
 * readOnly属性表示该方法为只读（一般用于查询的方法中，有助于提高性能）
 * timeout属性表示该方法执行的超时时间（默认为30秒）
 * isolation属性设置事务的隔离级别(一般情况都使用数据库默认的方式，不需要配置)
 * 
 * @author Administrator
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 该方法会提交,因为默认回滚的异常是RuntimeException,不是Exception
	 */
	@Override
	public void save(User user) throws Exception  {
		userDao.save(user);
		throw new Exception("save Exception");		
	}
	
	/**
	 * 该方法会回滚,因为修改了回滚的异常是Exception
	 * @param user
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void save2(User user) throws Exception  {
		userDao.save(user);
		throw new Exception("save Exception");		
	}

	/**
	 * 该方法会回滚,因为默认回滚的异常是RuntimeException
	 */
	@Override
	public void update(User user) throws SQLException {
		userDao.update(user);
		throw new RuntimeException("update exception");
	}

	/**
	 * (无效)该方法会回滚,因为修改了回滚的异常是Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void delete(int id) throws Exception {
		userDao.delete(id);
		//throw new Exception("delete Exception");//bug,抛出异常后不执行删除
	}

	/**
	 * 查询一般不需要事务
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询一般不需要事务
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public User findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
