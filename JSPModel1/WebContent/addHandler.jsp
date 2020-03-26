<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.vince.model.Teacher,com.vince.dao.TeacherDao,com.vince.dao.impl.TeacherDaoImpl"%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String desc = request.getParameter("description");
	Teacher t = new Teacher(name, desc, Integer.parseInt(age));

	TeacherDaoImpl dao = new TeacherDaoImpl();
	boolean flag = dao.insert(t);
	if(flag){
		response.sendRedirect("list.jsp");
	}
%>