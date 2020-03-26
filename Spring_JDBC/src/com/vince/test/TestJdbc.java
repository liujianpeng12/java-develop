package com.vince.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.dao.PersonDao;
import com.vince.entity.Person;

/**
 * 在Spring应用中使用JdbcTemplate,NamedParameterJdbcTemplate和SimpleJdbcTemplate实现CRUD操作
 * @author Administrator
 *
 */
public class TestJdbc {
	
	ApplicationContext ctx=null;
	
	@Before
	public void initCtx(){
		ctx=new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void testAdd(){
		Person p=new Person("小明", 21);
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		dao.add(p);
		System.out.println("添加成功");
	}
	
	@Test
	public void testAdd2(){
		Person p=new Person("小黄", 21);
		PersonDao dao=(PersonDao)ctx.getBean("personDao2");
		dao.add(p);
		System.out.println("添加成功");
	}
	
	@Test
	public void testInsert(){
		Person p=new Person("小s", 15);
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		int id=dao.insert(p);
		System.out.println("添加成功,Id="+id);
	}
	
	@Test
	public void testUpdate(){
		Person p=new Person(3,"小明", 12);
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		dao.update(p);
		System.out.println("修改成功");
	}
	
	@Test
	public void testDelete(){
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		dao.delete(5);
		System.out.println("删除成功");
	}
	
	@Test
	public void testGet(){
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		Person p=dao.get(1);
		System.out.println(p);
	}
	
	@Test
	public void testGet3(){
		PersonDao dao=(PersonDao)ctx.getBean("personDao3");
		Person p=dao.get(1);
		System.out.println(p);
	}
	
	@Test
	public void testList(){
		PersonDao dao=(PersonDao)ctx.getBean("personDao");
		List<Person> list=dao.list();
		for (Person person : list) {
			System.out.println(person);
		}		
	}
}
