<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>ServletContextListener:应用上下文生命周期监听器</li>
		<li>ServletContextAttributeListener:应用上下文属性事件监听器</li>
		<li>ServletRequestListener:请求周期监听器</li>
		<li>ServletRequestAttributeListener:应用上下文生命周期监听器</li>
		<li>ServletContextListener:请求属性事件监听器</li>
		<li>HttpSessionListener:会话生命周期监听器</li>
		<li>HttpSessionActivationListener:会话激活和钝化事件监听器</li>
		<li>HttpSessionAttributeListener:会话属性事件监听器</li>
		<li>HttpSessionBindingListener:会话值绑定事件监听器</li>
	</ul>
	
	<h2>用户登录</h2>
	<form action="LoginServlet">
		name:<input type="text" name="name"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>