<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${10+12}
	
	<%
		session.setAttribute("user","小刘");
	%>
	<%=session.getAttribute("user") %>	
	EL:${sessionScope.user}	
	EL:${sessionScope["user"] }
	
	<br/>
	${1>8 }
	${1==1 && 2>1 }
	是否为空:${empty sessionScope.user }
	
	<br>
	<%--EL隐含对象 --%>
	EL隐含对象: pageContext,pageScope,requestScope,sessionScope,applicationScope,
	param,paramValues,header,headerValues,cookie,initParam 等 <br>
	根路径:${pageContext.request.contextPath }
	
	<br/>
	<%
		response.addCookie(new Cookie("username","admin"));
	%>
	Cookie: ${cookie.username.value }
</body>
</html>