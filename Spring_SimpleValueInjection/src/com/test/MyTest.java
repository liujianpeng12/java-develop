package com.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.CollectionBean;
import com.bean.Student;

public class MyTest {

	@Test
	public void testSimpleBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Student s = (Student) ctx.getBean("studentBean");
		System.out.println(s);
	}

	@Test
	public void testCollectionBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CollectionBean cb = (CollectionBean) ctx.getBean("collectionBean");
		System.out.println("------------list--------------");
		for (String s : cb.getList()) {
			System.out.println(s);
		}

		System.out.println("------------map--------------");
		Map<Integer, String> map = cb.getMap();
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int key=it.next();
			System.out.println(key + ":" + map.get(key));
		}

		System.out.println("------------set--------------");
		Set<String> set = cb.getSet();
		Iterator<String> it2 = set.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		System.out.println("------------properties--------------");
		Properties props = cb.getProps();
		String name = props.getProperty("name");
		String age=props.getProperty("age");
		System.out.println(name+age+"Ëê");
	}
}
