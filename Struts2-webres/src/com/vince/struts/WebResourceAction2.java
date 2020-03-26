package com.vince.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 与ServletAPI耦合的方式访问web资源
 * 2.通过实现struts提供的Servlet各种Aware接口访问web资源
 * @author Administrator
 *
 */
public class WebResourceAction2 extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	HttpServletRequest request=null;
	HttpServletResponse response=null;
	
	public String execute(){
		request.setAttribute("requestName", "WebResourceAction2.reauest");
		request.getSession().setAttribute("sessionName", "WebResourceAction2.session");
		
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
	}

}
