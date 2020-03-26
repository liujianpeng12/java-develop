package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Student;
import com.vince.entity.Teacher;

/**
 * 关联关系映射-多对多
 * @author Administrator
 *
 */
public class OneToOneTest {

	@Test
	public void add() {
		Teacher t1=new Teacher("张老师",22);
		Student s1=new Student("张同学");
		Student s2=new Student("李同学");
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		
		HibernateUtil.add(t1);
	}
	
	@Test
	public void getTeacher() {
		Teacher t1=(Teacher) HibernateUtil.get(Teacher.class, 2);
		System.out.println(t1);
	}
}
