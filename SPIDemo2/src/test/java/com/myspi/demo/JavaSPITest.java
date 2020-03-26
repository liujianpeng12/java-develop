package com.myspi.demo;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class JavaSPITest {

	@Test
	public void sayHello(){
		ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
		System.out.println("Java SPI");
		Iterator<Robot> it = serviceLoader.iterator();
		while(it.hasNext()){
			it.next().sayHello();
		}
	}
	
	@Test
	public void sayDubboSPI(){
		ExtensionLoader<DubboRobot> extensionLoader = ExtensionLoader.getExtensionLoader(DubboRobot.class);
		DubboRobot optimusPrime = extensionLoader.getExtension("optimusPrime");
		optimusPrime.sayHello();
		DubboRobot bumblebee = extensionLoader.getExtension("bumblebee");
		bumblebee.sayHello();
	}
}
