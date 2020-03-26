package com.vince.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vince.dao.impl.FriendDaoImpl;
import com.vince.model.Friend;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("Action");
		switch(action){
			case "findAll":
				findAll(request,response);
			break;
			case "find":
				find(request,response);
			break;
			case "add":
				add(request,response);
			break;
			case "update":
				update(request,response);
			break;
			case "delete":
				delete(request,response);
			break;
		}
	}
	
	private void findAll(HttpServletRequest request,HttpServletResponse response){
		FriendDaoImpl dao=new FriendDaoImpl();
		List<Friend> list=dao.findAll();
		try {
			request.setAttribute("friends", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void find(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		FriendDaoImpl dao=new FriendDaoImpl();
		Friend f=dao.findById(Integer.parseInt(id));
		try {
			request.setAttribute("friend", f);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String desc=request.getParameter("description");
		FriendDaoImpl dao=new FriendDaoImpl();
		Friend f=new Friend(name,Integer.parseInt(age),desc);
		dao.insert(f);
		try {
			response.sendRedirect(request.getContextPath()+"/FriendServlet?Action=findAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String desc=request.getParameter("description");
		FriendDaoImpl dao=new FriendDaoImpl();
		Friend f=new Friend(Integer.parseInt(id),name,Integer.parseInt(age),desc);
		dao.update(f);
		try {
			response.sendRedirect(request.getContextPath()+"/FriendServlet?Action=findAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");		
		FriendDaoImpl dao=new FriendDaoImpl();
		dao.delete(Integer.parseInt(id));
		try {
			response.sendRedirect(request.getContextPath()+"/FriendServlet?Action=findAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
