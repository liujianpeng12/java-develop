package com.test;

import org.junit.Test;

import com.bean.DaoBean;
import com.bean.ServiceBean;
import com.mySpring.MyApplicationContext;

public class TestMyCtx {

	@Test
	public void test(){
		MyApplicationContext ctx=new MyApplicationContext("beans.xml");
		
//		DaoBean dao=(DaoBean)ctx.getBean("daoBean");
//		dao.save();
		
		ServiceBean ser=(ServiceBean)ctx.getBean("serviceBean");
		ser.save();
	}
}
