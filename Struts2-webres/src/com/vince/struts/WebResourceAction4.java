package com.vince.struts;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 与ServletAPI解耦的方式访问web资源
 * 2.通过实现struts提供的各种Aware接口访问web资源  -- 通常情况下使用该种方式
 * @author Administrator
 *
 */
public class WebResourceAction4 extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,CookiesAware,ParameterAware {

	Map<String, Object> request=null;
	Map<String, Object> session=null;
	Map<String, Object> application=null;
	Map<String, String> cookies=null;
	Map<String, String[]> params=null;
	public String execute(){
		request.put("requestName", "WebResourceAction4.requestName1");
		session.put("sessionName", "WebResourceAction4.sessionName1");
		return SUCCESS;
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application=arg0;
	}

	@Override
	public void setCookiesMap(Map<String, String> arg0) {
		cookies=arg0;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		params=arg0;
	}

}
