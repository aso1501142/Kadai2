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
<h1 id="manahead">ゼミ受講システム(管理者)</h1>
<div class="center">
<h1 id="title">科目申込状況</h1>


	<h3 id="it">IT</h3>
	<div class="accordion">
		<div class="item">
		<a class="accordion-control">
		<ul class="accordion-pane1">
			<c:forEach var="it" items="${it}">
				<br><a href="Subject_list?sub=${it.sub_id}"><c:out value="${it.sub_name}"></c:out></a></br>
			</c:forEach>
		</ul>
		<i class="fa fa-plus"></i></a>
		</div>
	</div>


	<h3 id="eng">English</h3>
	<div class="accordion">
		<div class="item">
		<a class="accordion-control2">
		<ul class="accordion-pane1">
			<c:forEach var="eng" items="${eng}">
				<br><c:out value="${eng.sub_name}"></c:out></li></br>
			</c:forEach>
		</ul>
		<i class="fa fa-plus"></i></a>
		</div>
	</div>


	<h3 id="comm">Communication</h3>
	<div class="accordio">
		<div class="item">
		<a class="accordion-control3">
		<ul class="accordion-pane1">
			<c:forEach var="com" items="${com}">
				<br><c:out value="${com.sub_name}"></c:out></br>
			</c:forEach>
		</ul>
		<i class="fa fa-plus"></i></a>
		</div>
	</div>

</div>
</body>
</html>