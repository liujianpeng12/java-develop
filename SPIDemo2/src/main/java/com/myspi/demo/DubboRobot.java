package com.myspi.demo;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface DubboRobot {
	void sayHello();
}
