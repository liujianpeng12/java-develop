package com.vince.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vince.dao.UserDao;
import com.vince.entity.User;

/**
 * 测试时不能采用junit方式,会找不到User.hbm.xml文件
 * 
 * Spring整合Hibernate
 * 一.加入框架jar包
 * 	1.加入spring jar包
 * 		AOP切面
 * 			aspectjrt.jar
 * 			aspectjweaver.jar
 * 			cglib-nodep-2.1_3.jar
 * 		核心包:spring.jar
 * 		注解:common-annotations.jar
 * 		日志:
 * 			commons-logging.jar
 * 			slf4j-api-1.5.0.jar
 * 			slf4j-log4j12-1.5.0.jar
 * 			log4j-1.2.15.jar
 * 		连接池dbcp:
 * 			commons-dbcp.jar
 * 			commons-pool.jar
 * 		Hibernate3支持包:
 * 			hibernate-annotations.jar
 * 			hibernate-commons-annotations.jar
 * 			hibernate-entitymanager.jar
 * 
 * 	2.加入hibernate3 jar包
 * 		hibernate核心包:
 * 			jta-1.1.jar
 * 			commons-collections-3.1.jar
 * 			hibernate3.jar
 * 			antlr-2.7.6.jar
 * 			javassist-3.12.0.GA.jar
 * 			dom4j-1.6.1.jar
 * 		jpa支持:hibernate-jpa-2.0-api-1.0.0.Final.jar
 * 
 * 	3.数据库驱动包:mysql-connector-java-5.1.23-bin.jar
 * 
 * 二.创建实体类:
 * 		User类
 * 
 * 三 .创建实体类的映射文件 User.hbm.xml
 * 
 * 四.在Spring配置文件中配置
 * 		1.配置读取数据库基本配置信息文件classpath下的db.properties文件
 * 		2.配置数据库源dataSource(本例使用dbcp连接池)
 * 		3.配置spring提供的sessionFactoryBean
 * 			(1)sessionFactory绑定的数据源
 * 			(2)hibernate映射文件
 * 			(3)hibernate相关配置项
 * 			注:如果使用hibernate.cfg.xml进行配置可省略以上3步,直接使用configLocation属性指定hibernate.cfg.xml的位置
 * 
 * 五.配置HibernateTempalte bean,通过构造器注入sessionFactory bean
 * 
 * 六.创建Dao接口及其实现类
 * 	通过注入HibernateTemplate工具类操作数据库
 * 
 * 七.编写测试
 * 			
 * 
 * @author Administrator
 *
 */
public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//insert();
//		update();
//		delete();
//		get();
		list();
	}
	
	public static void insert(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user = new User("小李", 23);
		dao.insert(user);
	}
	
	public static void update(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user = new User(11,"小红", 21);
		dao.update(user);
	}
	
	public static void delete(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		dao.delete(13);
	}
	
	public static void get(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		User user=dao.get(12);
		System.out.println(user);
	}
	
	public static void list(){
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=(UserDao)ctx.getBean("userDao");
		List<User> list=dao.list();
		for (User user : list) {
			System.out.println(user);
		}		
	}
}
