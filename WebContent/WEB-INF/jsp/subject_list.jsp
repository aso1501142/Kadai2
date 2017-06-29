<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目一覧</title>
</head>
<body>

	<h3>IT</h3>
	<ul>
		<c:forEach var="it" items="${it}">
		<li><a href="Subject_list?sub=${it.sub_id}"><c:out value="${it.sub_name}"></c:out></a></li>
		</c:forEach>
	</ul>

	<h3>English</h3>
	<ul>
		<c:forEach var="eng" items="${eng}">
			<li><c:out value="${eng.sub_name}"></c:out></li>
		</c:forEach>
	</ul>


	<h3>IT</h3>
	<ul>
		<c:forEach var="com" items="${com}">
			<li><c:out value="${com.sub_name}"></c:out></li>
		</c:forEach>
	</ul>


</body>
</html>