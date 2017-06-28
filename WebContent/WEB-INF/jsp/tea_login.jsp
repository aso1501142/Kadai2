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

	<div id="targe" style="color: red;">
		<c:forEach var="error" items ="${errorMessageList}" varStatus="status">
			<p>
				<c:out value="${error}" />
			</p>
		</c:forEach>
		<c:out value="${errorMessage}" />
	</div>

	<div class="center">
	<div class="manaballoon">

	<form method="post" action="Tea_login">
	<table>

			<label>ID</label><br/>
			<input type="text" name="tea_id"/>
			<br/><br/>

			<label>Password</label><br/>
			<input type="password" name="tea_password">
			<br/><br/>

	</table>
	</div>

	<input id="Manabutton" type="submit" name="submit" value="Login"/>
	<br/>

	</form>
	</div>

</body>
</html>