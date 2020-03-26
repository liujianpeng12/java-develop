<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page 
	import="com.vince.model.Teacher,com.vince.dao.TeacherDao,com.vince.dao.impl.TeacherDaoImpl"%>

<%
	String tid=request.getParameter("tid");

	TeacherDaoImpl dao = new TeacherDaoImpl();
	boolean flag = dao.delete(Integer.parseInt(tid));
	if(flag){
		response.sendRedirect("list.jsp");
	}
%>