<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.vince.model.Teacher,com.vince.dao.TeacherDao,com.vince.dao.impl.TeacherDaoImpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师信息列表</title>
<script>
	function doDelete(tid){
		if(window.confirm("确定删除吗?")){
			window.location="deleteHandler.jsp?tid="+tid;
		}
	}
</script>
</head>
<body>
	<%
		TeacherDaoImpl dao=new TeacherDaoImpl();
		List<Teacher> teachers=dao.findAll();
	%>
	<h2>老师信息列表</h2>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<%
			for(int i=0;i<teachers.size();i++){
				Teacher t=teachers.get(i);
		%>
			<tr>
				<th><%=t.getTid() %></th>
				<th><%=t.getName() %></th>
				<th><%=t.getAge() %></th>
				<th><%=t.getDescription() %></th>
				<th>
					<a href="update.jsp?tid=<%=t.getTid()%>">修改</a> | 
					<a href="javascript:void(0)" onclick="doDelete(<%=t.getTid()%>)">删除</a>
				</th>
			</tr>
		<%
			}
		%>
	</table>
	<br/>
	<br/>
	<a href="index.jsp">首页</a> <a href="add.jsp">添加</a>
</body>
</html>