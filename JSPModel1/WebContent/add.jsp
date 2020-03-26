<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
	<form action="addHandler.jsp" method="post">
		name:<input type="text" name="name" /><br/>
		age:<input type="text" name="age" /><br/>
		desc:<textarea rows="5" cols="25" name="description"></textarea>
		<input type="submit" value="添加" />
	</form>
</body>
</html>