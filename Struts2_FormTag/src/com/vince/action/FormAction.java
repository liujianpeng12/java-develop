package com.vince.action;

import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport {
	
	private String name;
	private String password;
	private boolean argee;
	private String[] like;
	private String sex;
	private String city;
	private String desc;
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isArgee() {
		return argee;
	}

	public void setArgee(boolean argee) {
		this.argee = argee;
	}

	

	public String[] getLike() {
		return like;
	}

	public void setLike(String[] like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "FormAction [name=" + name + ", password=" + password
				+ ", argee=" + argee + ", like=" + Arrays.toString(like)
				+ ", sex=" + sex + ", city=" + city + ", desc=" + desc + "]";
	}

	public String execute(){
		System.out.println(toString());
		return SUCCESS;
	}
}
