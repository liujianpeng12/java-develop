<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>get接收数据</h1>
	<%
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		name=URLDecoder.decode(name,"utf-8");
		//name=new String(name.getBytes("iso-8859-1"),"UTF-8");
		out.println(name);
		out.println(email);
	%>
</body>
</html>