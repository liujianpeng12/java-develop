package com.vince.entity;

/**
 * 继承关系映射-每个类映射一个表(Cat类生成一个表)
 * @author Administrator
 *
 */
public class Cat extends Animal {

	private String catProperty;

	public String getCatProperty() {
		return catProperty;
	}

	public void setCatProperty(String catProperty) {
		this.catProperty = catProperty;
	}
}
