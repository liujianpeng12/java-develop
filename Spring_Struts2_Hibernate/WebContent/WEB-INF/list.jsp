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
	<h2>列表</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>收入</th>
			<th>更新</th>
			<th>删除</th>
		</tr>
		<s:iterator value="#request.emps">
			<tr>
				<td>${id }</td>
				<td>${name }</td>
				<td>${age }</td>
				<td>${salary }</td>
				<td><a href="emp_findById.action?id=${id }">更新</a></td>
				<td><a href="emp_delete.action?id=${id }">删除</a></td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="6">
				<a href="emp_doAdd.action">添加</a>
			</td>
		</tr>
	</table>
</body>
</html>