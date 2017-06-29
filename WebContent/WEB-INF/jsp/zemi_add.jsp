<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題2</title>
<link href="css/kadai2.css" rel="stylesheet" type="text/css" charset="utf-8"/>
</head>
<body id="managerpage">

<h1 id="manahead">ゼミ受講システム(管理者)</h1>

	<div id="target" style="color: red;">
		<c:forEach var="error" items="${errorMessageList}" varStatus="status">
			<p>
				<c:out value="${error}" />
			</p>
		</c:forEach>
		<c:out value="${errorMess}" />
	</div>

	<div class="center">

<h1 id="title">ゼミ科目登録</h1>

	<form method="post" action="Zemi_add">

		<span style="line-height:300%">科目ID</span>
		<input type="text" name="subId" /><br/>
		<span style="line-height:300%">科目名</span>
		<input type="text" name="subName" /><br>
		<span style="line-height:300%">科目分類</span>
		<input type="text"name="subGroup" /><br>
		<span style="line-height:300%">担当教師ID</span>
		<input type="text" name="tea_Id" /><br>

		<a href="Zemi_add">
			<input id="Manabutton" type="submit" name="back" value="戻る" />
		</a>
			<input id="Manabutton" type="submit" name="submit" value="確認画面へ" />

	</form>
	</div>

</body>
</html>