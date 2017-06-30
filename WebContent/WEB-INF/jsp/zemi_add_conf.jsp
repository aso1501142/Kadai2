<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/kadai2.css" rel="stylesheet" type="text/css" charset="utf-8"/>
</head>
<body id="managerpage">
<h1 id="manahead">ゼミ受講システム(管理者)</h1>
<div class="center">
<h1 id="title">ゼミ科目確認</h1>

	<form method="post" action="Zemi_add_conf">
		<p>
			<span style="line-height:300%">科目ID:<%= session.getAttribute("zemiId") %></span>
			<input name="Text1" type="text" /><br/>

			<span style="line-height:300%">科目名:<%= session.getAttribute("zemiName") %></span>
			<input name="Text1" type="text" /><br/>

			<span style="line-height:300%">科目分類名:<%= session.getAttribute("zemiGroup") %></span>
			<input name="Text1" type="text" /><br/>

			<span style="line-height:300%">担当教師ID:<%= session.getAttribute("teaId") %></span>
			<input name="Text1" type="text" /><br/>

		<p>
		<a href="Zemi_add_conf">
			<input id="Manabutton" name="back" type="button"value="戻る">
		</a>
			<input id="Manabutton" type="submit" value="登録"/>
	</form>
</div>


</body>
</html>