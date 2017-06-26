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

<h1 id="mainhead">ゼミ受講システム</h1>


	<table>
	<tr>
		<td>
			<a href="Stu_login" >
			<input type="submit" value="生徒ログイン" style="background:skyblue; color:white;">
			</a>
		</td>

		<td>
			<!--  <a href="Tea_login">
			<input type="submit" value="管理者ログイン" style="background:orange; color:white;">
			</a>  -->
			<form method="get" action="Tea_login">
			<input type="submit" value="管理者ログイン" style="background:orange; color:white;">
			</form>
		</td>
	</tr>
	</table>

</body>
</html>