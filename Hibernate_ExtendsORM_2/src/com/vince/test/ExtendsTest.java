package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Cat;
import com.vince.entity.Dog;

public class ExtendsTest {

	@Test
	public void test() {
		Cat cat=new Cat();
		cat.setName("小猫2");
		cat.setAge(2);
		cat.setCatProperty("好看的猫");
		
		Dog dog=new Dog();
		dog.setName("小狗2");
		dog.setAge(2);
		dog.setDogProperty("好看的狗");
		
		HibernateUtil.add(cat);
		HibernateUtil.add(dog);
	}

}
