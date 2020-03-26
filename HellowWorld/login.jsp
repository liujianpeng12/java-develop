<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Contact List 1.0</h2>
	<hr size="2"/>
	<fieldset>
		<legend><b>Please Login</b></legend>
		<form action="loginAction.perform" method="post">
			<table>
				<tr>
					<td>username:</td>
					<td><input type="text" size="30" name="username"/>testuser</td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="text" size="30" name="password"/>password</td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="Login" name="login"/>
		</form>
		<%=request.getScheme() %>
	</fieldset>
</body>
</html>