<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>struts2 result 结果类型</h2>
	<a href="dispatcherAction">dispatcher结果类型:请求转发(使用同一个请求对象),是struts2的默认类型</a><br>
	<a href="redirectAction">redirect类型,可以使用OGNL表达式:\${name}</a><br>
	<a href="redirectActionAction">redirectAction结果类型:重定向到一个Action</a>
</body>
</html>