<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.vince.model.Friend" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<script>
	function doDelete(tid){
		if(window.confirm("确定删除吗?")){
			window.location="FriendServlet?Action=delete&id="+tid;
		}
	}
</script>
</head>
<body>
	<%
		List<Friend> list=(List<Friend>)request.getAttribute("friends");
	%>
	<h2>列表(普通方式)</h2>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<% 
			for(int i=0; i<list.size(); i++){
				Friend f=list.get(i);			
		%>
			<tr>
				<th><%=f.getId() %></th>
				<th><%=f.getName() %></th>
				<th><%=f.getAge() %></th>
				<th><%=f.getDescription() %></th>
				<th>
					<a href="FriendServlet?Action=find&id=<%=f.getId()%>">修改</a> | 
					<a href="javascript:void(0)" onclick="doDelete(<%=f.getId()%>)">删除</a>
				</th>
			</tr>
		<%
			}
		%>
	</table>
	<br/>
	<h2>列表(JSTL方式)</h2>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.friends }" var="friend">
			<tr>
				<td>${friend.id }</td>
				<td>${friend.name }</td>
				<td>${friend.age }</td>
				<td>${friend.description }</td>
				<td>
					<a href="FriendServlet?Action=find&id=${friend.id }">修改</a> | 
					<a href="javascript:void(0)" onclick="doDelete(${friend.id })">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<jsp:include page="Pageroll.jsp">
					<jsp:param value="FriendServlet?Action=list" name="method"/>
				</jsp:include>
			</td>
		</tr>
	</table>
	<br/>
	<a href="add.jsp">添加</a>
</body>
</html>