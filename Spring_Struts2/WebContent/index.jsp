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
	<h2>Spring + Struts2</h2>
	<h1>D:\JAVA\struts-2.3.20\apps\struts2-blank\WEB-INF\lib 目录下的包不行,struts-2.3.8的应该可以</h1>
	<ul>
		spring_struts2 的要点
		<li>1.配置spring的配置文件,让web服务器启动时加载. 该配置在web.xml中进行</li>
		<li>2.把action对象的创建与管理交给spring容器来完成. 该配置在struts.xml中进行</li>
		<li>3.在spring配置文件中配置action bean</li>
	</ul>
	<s:form action="hello">
		<s:textfield name="name"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>