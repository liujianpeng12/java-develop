<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="com.roywmiller.contacts.model.ContactsUser"></jsp:useBean>
	<h2>Contact List 1.0</h2>
	<hr size="2"/>
	Goodbye <%= user.getUsername() %>!
	<h2><a href="login.jsp">Login</a></h2>
	</body>
</body>
</html>