<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<input type="submit" value="ログアウト" />

	<form method="post" action="">

		<button name="action" value="zemi">ゼミ科目登録</button>
		<a href="Zemi_change" tabindex="-1">
			<input name="change" type="button" value="変更・削除">
		</a>
		<button name="action" value="entry">申込状況</button>

	</form>

</body>
</html>