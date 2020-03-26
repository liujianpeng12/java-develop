package com.jdbc.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;
import com.jdbc.service.UserService;

/**
 * Spring事务管理中使用注解
 * @author Administrator
 *
 */
public class Test {

	ApplicationContext ctx=null;
	UserService us=null;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		us=(UserService)ctx.getBean("userService");
	}
	
	@org.junit.Test
	public void save() throws Exception{
		User user=new User("Tomer",22);
		us.save(user);
	}
	
	@org.junit.Test
	public void save2() throws Exception{
		User user=new User("Tomer",22);
		us.save2(user);
	}

	@org.junit.Test
	public void update() throws Exception{
		User user=new User(1,"Tomer",22);
		us.update(user);
	}
	
	@org.junit.Test
	public void delete() throws Exception{
		us.delete(7);
	}
}
