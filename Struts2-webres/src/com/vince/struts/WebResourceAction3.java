package com.vince.struts;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 与ServletAPI解耦的方式访问web资源
 * 1.通过ActionContext方式访问
 * @author Administrator
 *
 */
public class WebResourceAction3 extends ActionSupport {
	
	
	public String execute(){
		
		//获取当前请求的ActionContext对象
		ActionContext ctx=ActionContext.getContext();
		//等同于ServletContext对象
		Map<String,Object> application=ctx.getApplication();
		//等同于HttpSession
		Map<String,Object> session=ctx.getSession();
		
		Map<String,Object> request=(Map<String,Object>)ctx.get("request");
		
		request.put("requestName", "WebResourceAction3.request");
		session.put("sessionName", "WebResourceAction3.session");
		
		return SUCCESS;
	}
}
