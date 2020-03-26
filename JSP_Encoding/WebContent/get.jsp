<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function onsubmitForm(){
		var form=document.forms["form1"];
		form.name.value=encodeURI(form.name.value);
		form.submit();
	}
</script>
</head>
<body>
	<h1>get提交数据</h1>
	<form name="form1" action="get_receive.jsp" onsubmit="onsubmitForm()" method="get">
		name: <input type="text" name="name" /><br/>
		email:<input type="text" name="email" />
		<br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>