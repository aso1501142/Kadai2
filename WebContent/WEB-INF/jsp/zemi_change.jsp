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
	<%
	ArrayList<String> subject = new ArrayList<String>();
	subject=(ArrayList)request.getAttribute("subject");
	System.out.println(subject);%>
</body>
</html>