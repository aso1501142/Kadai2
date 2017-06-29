<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題2</title>
<link href="css/kadai2.css" rel="stylesheet" type="text/css" charset="utf-8"/>
</head>
<body id="managerpage">

<h1 id="manahead">受講システム(管理者)</h1>

<div class="center">
<h1 id="title">ゼミ科目変更・削除</h1>
<table border="1">

		<tr>
			<span style="line-height:300%"><td>科目名</td></span>
			<span style="line-height:300%"><td>科目分類名</td></span>
			<span style="line-height:300%"><td></td></span>
			<span style="line-height:300%"><td></td></span>
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
</div>

</body>
</html>