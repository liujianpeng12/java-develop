package com.vince.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vince.db.util.HibernateUtil;
import com.vince.entity.Address;
import com.vince.entity.Zoom;

/**
 * 组件关系映射
 * @author Administrator
 *
 */

public class ComponentTest {

	@Test
	public void add() {
		Zoom z=new Zoom("公园");
		Address addr=new Address("北京路","123号");
		
		z.setAddress(addr);
		
		HibernateUtil.add(z);
	}

	@Test
	public void getZoom(){
		Zoom z=(Zoom) HibernateUtil.get(Zoom.class, 1);
		System.out.println(z);
	}
	
}
