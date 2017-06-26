<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題2</title>
</head>
<body>

<h2>ゼミ受講システム(生徒)</h2>

	<form method="post" action="/zemi/Stu_login">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="stu_id" size="15"></td>
		</tr>

		<tr>
			<td>Password</td>
			<td><input type="password" name="stu_password" size="15"></td>
		</tr>

	</table>

	<input type="submit" value="Login">
	</form>

</body>
</html>