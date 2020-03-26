<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
	function firstPage(){
		var _pageIndex=document.pagerollForm.pageIndex.value;
		if(_pageIndex==1){
			alert("当前页已经是首页.");
			return;
		}
		document.pagerollForm.pageIndex.value=1;
		document.pagerollForm.submit();
	}
	function prevPage(){
		var _pageIndex=document.pagerollForm.pageIndex.value;
		if(_pageIndex==1){
			alert("当前页已经是首页.");
			return;
		}
		document.pagerollForm.pageIndex.value=--_pageIndex;
		document.pagerollForm.submit();
	}
	function nextPage(){
		var _pageIndex=document.pagerollForm.pageIndex.value;
		var _pageCount=document.pagerollForm.pageCount.value;
		if(_pageIndex==_pageCount){
			alert("当前页已经是最后一页.");
			return;
		}
		document.pagerollForm.pageIndex.value=++_pageIndex;
		document.pagerollForm.submit();
	}
	function lastPage(){
		var _pageIndex=document.pagerollForm.pageIndex.value;
		var _pageCount=document.pagerollForm.pageCount.value;
		if(_pageIndex==_pageCount){
			alert("当前页已经是最后一页.");
			return;
		}
		document.pagerollForm.pageIndex.value=_pageCount;
		document.pagerollForm.submit();
	}
	function gotoPage(){
		var _pageIndex=document.pagerollForm.sel_gotoPage.value;
		document.pagerollForm.pageIndex.value=_pageIndex;
		document.pagerollForm.submit();
	}
</script>
</head>
<body>
	<form name="pagerollForm" action="${param.method }" method="post">
		当前页:${requestScope.pageRoll.pageIndex }|
		总页数:${requestScope.pageRoll.pageCount }|
		总记录数:${requestScope.pageRoll.totalCount }|
		
		<input type="hidden" name="pageIndex" value="${requestScope.pageRoll.pageIndex }">
		<input type="hidden" name="pageCount" value="${requestScope.pageRoll.pageCount }">
		
		<input type="button" value="首页" onclick="firstPage()" />
		<input type="button" value="上一页" onclick="prevPage()" />
		<input type="button" value="下一页" onclick="nextPage()" />
		<input type="button" value="末页" onclick="lastPage()" />
		<select name="sel_gotoPage" onchange="gotoPage()">
			<c:forEach begin="1" end="${requestScope.pageRoll.pageCount }" var="i">
				<c:choose>
					<c:when test="${i==requestScope.pageRoll.pageIndex }">
						<option value="${i }" selected="selected">${i }</option>
					</c:when>
					<c:otherwise>
						<option value="${i }">${i }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</form>
</body>
</html>