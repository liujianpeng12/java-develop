package com.vince.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncServlet
 */
@WebServlet(urlPatterns={"/AsyncServlet"},asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsyncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("start...");
		
		//耗时操作
		AsyncContext ac=request.startAsync();
		ac.addListener(new MyAsyncListener());
		ac.start(new MyThread(ac));
		
		out.println("end...");
		out.flush();
	}

	class MyThread implements Runnable{
		private AsyncContext ac;
		public MyThread(AsyncContext as){
			this.ac=as;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				ac.getResponse().getWriter().println("耗时操作完成!");
				ac.complete();//完成
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
