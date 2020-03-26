package com.vince.test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.vince.dao.EmpDao;
import com.vince.dao.impl.EmpDaoImpl;
import com.vince.domain.Emp;

public class MyTest {

	public static void main(String[] args) throws InterruptedException{
		//Emp emp=new Emp(20,"Ãû×Ö2","Å®",40000,20);
		
		final EmpDao empDao=new EmpDaoImpl();
		int num = 1000;
		
		final CountDownLatch latch = new CountDownLatch(num);
		
		for (int i = 0; i < num; i++) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					latch.countDown();
					
					try {
						latch.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Emp e=empDao.Get(1);
					System.out.println(e);
					
			}}).start();
		}
		
		
		System.out.println("½áÊø!!!");
	}
}
