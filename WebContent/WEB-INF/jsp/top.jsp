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
<body>

<h1 id="manahead">ゼミ受講システム(管理者)</h1>

	<input type="submit" value="ログアウト" />

	<div class="center">

	<form action="Top_zemi_add" method="post">
		<input id="Zemibutton" type="submit" name="action" value="ゼミ科目登録" style="width:400px; height:100px"/><br/>
	</form>

		 <!-- <a href="WEB-INF/jsp/zemi_add.jsp" tabindex="0">
			<input name="add" type="button" value="ゼミ科目登録" onclick="location.href='WEB-INF/jsp/zemi_add.jsp'">
		</a> -->

	<a href="Zemi_change" tabindex="-1">
		<input id="Zemibutton" type="submit" name="change" value="ゼミ科目変更・削除" style="width:400px; height:100px"/><br/>
	</a>

	<form action="Top" method="POST">
		<input id="Zemibutton" type="submit" name="action" value="ゼミ科目申込状況" style="width:400px; height:100px"/><br/>
	</form>

	</div>

</body>
</html>