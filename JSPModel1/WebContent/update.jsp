<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ page import="com.vince.model.Teacher,com.vince.dao.TeacherDao,com.vince.dao.impl.TeacherDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String tid=request.getParameter("tid");
		TeacherDaoImpl dao = new TeacherDaoImpl();
		Teacher t=dao.findById(Integer.parseInt(tid));
	%>
	<h2>修改信息</h2>
	<form action="updateHandler.jsp" method="post">
		tid:<input type="text" name="tid" value="<%=t.getTid() %>" readonly /><br/>
		name:<input type="text" name="name" value="<%=t.getName() %>" /><br/>
		age:<input type="text" name="age" value="<%=t.getAge() %>" /><br/>
		desc:<textarea rows="5" cols="25" name="description"><%=t.getDescription() %></textarea>
		<input type="submit" value="修改" />
	</form>
</body>
</html>