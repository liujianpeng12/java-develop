<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list=new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		request.setAttribute("city", list);
	%>
	<s:form action="formAction">
		<s:textfield name="name" label="name"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:checkbox name="argee" label="argee"></s:checkbox>
		<s:checkboxlist name="like" label="like" list="#{'1':'足球','2':'蓝球','3':'乒乓球' }"></s:checkboxlist>
		<s:radio name="sex" label="sex" list="#{'0':'男','1':'女' }"></s:radio>
		<s:select name="city" label="city" list="#request.city" headerKey="" headerValue="请选择...">
			<s:optgroup list="#{'shenzhen':'深圳','dongguang':'东莞' }" label="广东省"></s:optgroup>
			<s:optgroup list="#{'nanning':'南宁','guilin':'桂林' }" label="广西"></s:optgroup>
		</s:select>
		<s:textarea name="desc" label="description" rows="10" cols="20"></s:textarea>
		<s:submit></s:submit>
	</s:form>
</body>
</html>