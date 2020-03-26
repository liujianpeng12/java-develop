<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>名字</th>
			<th>性别</th>
			<th>年龄</th>
			<th>电话</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<s:iterator value="#request.list">
			<tr>
			<th>${id }</th>
			<th>${name }</th>
			<th>${sex }</th>
			<th>${age }</th>
			<th>${phone }</th>
			<th><a href="student_get?id=${id }">修改<a/></th>
			<th><a href="student_delete?id=${id }">删除<a/></th>
		</tr>
		</s:iterator>
	</table>
	<br>
	<a href="student_doAdd">添加</a>
</body>
</html>