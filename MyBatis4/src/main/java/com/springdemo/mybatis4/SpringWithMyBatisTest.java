package com.springdemo.mybatis4;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-mybatis.xml")
public class SpringWithMyBatisTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /** 自动注入 AuthorDao，无需再通过 SqlSession 获取 */ 
    @Autowired
    private EmpMapper empMapper;


    @Before
    public void printBeanInfo() {
        ListableBeanFactory lbf = applicationContext;
        String[] beanNames = lbf.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        System.out.println();
        System.out.println("----------------☆ bean name ☆---------------");
        Arrays.asList(beanNames).subList(0, 5).forEach(System.out::println);
        System.out.println();

        EmpMapper empMapper = (EmpMapper) applicationContext.getBean("empMapper");

        System.out.println("-------------☆ bean class info ☆--------------");
        System.out.println("EmpMapper  Class: " + empMapper.getClass());
        System.out.println("\n--------xxxx---------xxxx---------xxx---------\n");
    }

    @Test
    public void testOne2One() {
    	try {

            Emp emp = empMapper.getEmp(1);

            System.out.println();
            System.out.println("emp info:");
            System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
