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
	<h2>修改</h2>
	<s:form action="emp_update" >
		<s:hidden name="emp.id"></s:hidden>
		<s:textfield name="emp.name" label="Name"></s:textfield>
		<s:textfield name="emp.age" label="Age"></s:textfield>
		<s:textfield name="emp.income" label="Income"></s:textfield>
		<s:submit name="保存"></s:submit>
	</s:form>
</body>
</html>