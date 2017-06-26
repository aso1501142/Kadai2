<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="target" style="color: red;">
		<c:forEach var="error" items="${errorMessageList}" varStatus="status">
			<p>
				<c:out value="${error}" />
			</p>
		</c:forEach>
		<c:out value="${errorMess}" />
	</div>


	<form method="post" action="Zemi_add">

		科目ID<input type="text" name="subId"><br>
		科目名<input type="text" name="subName"><br>
		科目分類<input type="text"name="subGroup"><br>
		<a href="top.jsp" tabindex="-1">
			<input name="back" type="button" value="戻る"onclick='location.href="top.jsp"'>
		</a>
		<input type=submit value="確認画面へ">
	</form>
</body>
</html>