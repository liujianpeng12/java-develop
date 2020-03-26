<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vince.model.Friend"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Friend f=(Friend)request.getAttribute("friend");
	%>
	<h2>修改信息</h2>
	<form action="FriendServlet?Action=update&id=<%=f.getId()%>" method="post">
		tid:<input type="text" name="tid" value="<%=f.getId() %>" readonly /><br/>
		name:<input type="text" name="name" value="<%=f.getName() %>" /><br/>
		age:<input type="text" name="age" value="<%=f.getAge() %>" /><br/>
		desc:<textarea rows="5" cols="25" name="description"><%=f.getDescription() %></textarea>
		<input type="submit" value="修改" />
	</form>
</body>
</html>