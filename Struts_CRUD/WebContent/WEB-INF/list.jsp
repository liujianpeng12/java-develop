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
			<th>年龄</th>
			<th>收入</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<s:iterator value="#request.emps">
			<tr>
				<th>${id }</th>
				<th>${name }</th>
				<th>${age }</th>
				<th>${income }</th>
				<th><a href="emp_get?id=${id }">修改</a></th>
				<th><a href="emp_delete?id=${id }">删除</a></th>
			</tr>
		</s:iterator>
	</table>
	<br>
	<a href="emp_doAdd">添加</a>
</body>
</html>