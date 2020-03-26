package com.vince.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet生命周期: servlet实例由web容器创建(tomcat),init方法在每一次请求时执行且只执行一次,
 * 以后每次请求时不再执行init方法,而是执行service方法,destory方法在关闭web容器时执行
 * 
 * 需要考虑线程安全的问题
 * 1.访问成员变量时
 * 2.访问共享资源时
 * 
 * Servlet 是线程不安全的,解决方法:
 * 1.servlet实现SingleThreadModel接口(已过时,会大量创建servlet实例)
 * 2.使用同步代码块 synchronized(会阻塞)
 * 3.不使用SingleThreadModel也不使用synchronize,同时不使用成员变量和共享资源(推荐)
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet implements SingleThreadModel {
	private static final long serialVersionUID = 1L;
       
	private static int count=0;//在servlet中定义成员变量,需要考虑线程安全问题
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void text(){
		synchronized(this){
			count++;
		}
	}
}
