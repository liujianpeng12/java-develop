<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vince.model.User,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htmlS PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
	<%
		request.setAttribute("name", "小明");
	%>
	<c:out value="${requestScope.name}"></c:out>
	
	<c:set var="age" value="19"></c:set>
	${age }
	<br/><br/>
	
	<c:if test="${not empty requestScope.name }">有效姓名</c:if>
	<c:if test="${empty requestScope.name }">无效姓名</c:if>
	<br>
	<c:choose>
		<c:when test="${age<18 }">未成年人</c:when>
		<c:when test="${age>=18 && age<=30 }">青年人</c:when>
		<c:when test="${age>=30 && age<=50 }">中年人</c:when>
		<c:otherwise>老年人</c:otherwise>
	</c:choose>S
	
	<!-- forEach -->
	<%
		List<User> users=new ArrayList<User>();
		User u1=new User("小明","男",22);
		User u2=new User("小亮","男",24);
		User u3=new User("小哥","男",33);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		request.setAttribute("users", users);
	%>
	<table>
		<tr>
			<th>name</th>
			<th>sex</th>
			<th>age</th>
			<th>状态值</th>
		</tr>
		<!-- 
			varStatus状态值
			index:索引
			count:当前遍历次数
			current:当前正在迭代的对象
			first:是否是第一个
			last:是否是最后一个
		 -->
		<c:forEach items="${requestScope.users}" var="user" varStatus="status" >
			<tr>
				<td>${user.name }</td>
				<td>${user.sex }</td>
				<td>${user.age }</td>
				<td>index:${status.index },count:${status.count },current:${status.current.name }
					,first:${status.first },last:${status.last }
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<b>forTokens:</b><br>
	<c:set var="books" value="蓝球,足球,游泳,拳击"></c:set>
	<c:forTokens items="${books }" delims="," var="vals">
		${vals }<br>
	</c:forTokens>
</body>
</html>