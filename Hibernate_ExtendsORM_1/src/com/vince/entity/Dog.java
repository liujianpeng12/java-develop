package com.vince.entity;

/**
 * 继承关系映射-Dog子类映射一个表
 * @author Administrator
 *
 */
public class Dog extends Animal {

	private String dogProperty;

	public String getDogProperty() {
		return dogProperty;
	}

	public void setDogProperty(String dogProperty) {
		this.dogProperty = dogProperty;
	}
}
