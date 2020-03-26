<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%!
	//JS声明片段
 	int i=1;
 	public void printint(){
 		System.out.println(i);
 	}
%>


</head>
<body>
 hi jsp
 
 <!-- JSP表达式 -->
 当前时间<%= new java.util.Date() %>
 
 <!-- JSP脚本 -->
 <%
	out.println("out.println 输出字符串");
 	out.write("out.write 输出字符串");
 	
 	printint();
 	String name="abc";
 	
 	for(int i=0;i<10;i++){
 		System.out.print(i);
 	}
 %>
 <br />
 <h1>请求转发</h1>
 <form action="receive.jsp">
 	<input type="text" name="email" />
 	<input type="submit" value="提交" />
 </form>
 
 <br />
 <h1>useBean</h1>
 <%-- 创建对象,调用默认构造方法 --%>
 <jsp:useBean id="person" class="com.vince.bean.Person"></jsp:useBean>
 <%--设置对象值 --%>
 <jsp:setProperty property="name" name="person" value="myname"/>
 <jsp:setProperty property="age" name="person" value="20"/>
 <%--获取对象值 --%>
 <jsp:getProperty property="name" name="person"/>
 <jsp:getProperty property="age" name="person"/>
</body>
</html>