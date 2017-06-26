<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目変更・削除</title>
</head>
<body>
	<h1>科目変更・削除</h1>

<table border="1">
		<tr>
			<td>科目名</td>
			<td>科目分類名</td>
			<td></td>
			<td></td>
		</tr>
	<c:forEach var="subject" items="${subjects}">
		<tr>
			<td><c:out value="${subject.sub_name}"></c:out></td>
			<td><c:out value="${subject.sub_group}"></c:out></td>
			<td>
			<form method="post" action="Zemi_change">
			<button type="submit" name="sub_id" value="${subject.sub_id}">変更</button>
			</form>
			</td>
			<td><input type="submit" value="削除"></td>
		</tr>

	</c:forEach>
</table>
</body>
</html>