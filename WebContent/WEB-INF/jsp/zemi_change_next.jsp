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

<h1 id="title">ゼミ科目変更</h1>

<!-- <table border="1">
		<tr>
			<td><c:out value="${subject.sub_id}"></c:out></td>
			<td><c:out value="${subject.sub_name}"></c:out></td>
			<td><c:out value="${subject.sub_group}"></c:out></td>
			<td><c:out value="${subject.tea_id}"></c:out></td>
		</tr>
</table> -->
	<form method="post" action="Zemi_change_next">
		<span style="line-height:300%">科目ID</span>
		<input type="text" name="subId" value="${subject.sub_id}" /><br/>
		<span style="line-height:300%">科目名</span>
		<input type="text" name="subName" value="${subject.sub_name}" /><br/>
		<span style="line-height:300%">科目分類</span>
		<input type="text"name="subGroup" value="${subject.sub_group}" /><br/>
		<span style="line-height:300%">教師ID</span>
		<input type="text" name="teaId" value="${subject.tea_id}" /><br/>


		<button type="submit" name="sub_id" value="${subject.sub_id}">確定</button>

		</form>
		</div>


</body>
</html>