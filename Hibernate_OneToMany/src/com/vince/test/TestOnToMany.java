package com.vince.test;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Article;
import com.vince.entity.User;

public class TestOnToMany {
	
	/**
	 * 关联关系映射-- 一对多:
	 * User为主对象,Article为从对象
	 */
	
	/**
	 * 一对多关联:
	 * 只手动添加主对象时,在主对象的配置中添加[cascade="all"],否则只添加了主对象或者从对象保存不了并抛出外键异常并回滚事务[inverse="true"]情况下;
	 * 如果手动添加主对象和从对象则不需要配置[cascade="all"]
	 * 
	 * 对象关系维护:在主对象配置中添加[inverse="true"]表示由从对象维护关联关联,表现在添加时不会有修改外键(user_id)的语句,
	 * 否则会有修改外键(user_id)的语句
	 */
	@Test
	public void add(){
		User user=new User("小迷", 23);	
		
		//Set<Article> articles=new HashSet<Article>();
		Article a1=new Article("标题5","内容1");
		Article a2=new Article("标题6","内容2");
		//articles.add(a1);
		//articles.add(a2);
		
		user.getArticles().add(a1);
		user.getArticles().add(a2);
		a1.setUser(user);
		a2.setUser(user);
		
		//只手动添加主对象时,在主对象的配置中添加[cascade="all"],否则从对象保存不了,抛出外键异常并回滚事务;
		HibernateUtil.add(user);
		//在主对象中配置[ cascade="all"]时就不需要手动插入从对象,否则需要手动插入从对象,如下语句
		//HibernateUtil.add(a1);
		//HibernateUtil.add(a2);
	}
	
	/**
	 * 查询主对象:在主对象配置中添加[lazy="false"]时会同时查询从对象,否则不会查询从对象
	 */
	@Test
	public void getUser(){
		Session session=HibernateUtil.getSession();
		User u=(User) session.get(User.class, 3);
		session.close();
		
		System.out.println(u);
		System.out.println(u.getArticles());
	}
	
	/**
	 * 查询从对象:在从对象配置中添加[fetch="join"]时会同时查询主对象,否则不会查询主对象
	 */
	@Test
	public void getArticle(){
		Session session=HibernateUtil.getSession();
		Article a=(Article) session.get(Article.class, 3);
		
		session.close();
		
		System.out.println(a);
		System.out.println(a.getUser());
		
	}
}
