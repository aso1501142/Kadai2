<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目変更画面</title>
</head>
<body>
<h1>科目変更画面</h1>

<!-- <table border="1">
		<tr>
			<td><c:out value="${subject.sub_id}"></c:out></td>
			<td><c:out value="${subject.sub_name}"></c:out></td>
			<td><c:out value="${subject.sub_group}"></c:out></td>
			<td><c:out value="${subject.tea_id}"></c:out></td>
		</tr>
</table> -->

		科目ID<input type="text" name="subId" value="${subject.sub_id}"><br>
		科目名<input type="text" name="subName" value="${subject.sub_name}"><br>
		科目分類<input type="text"name="subGroup" value="${subject.sub_group}"><br>
		教師ID<input type="text" name="subId" value="${subject.tea_id}"><br>

		<form method="post" action="Zemi_change_next">
			<button type="submit" name="sub_id" value="${subject.sub_id}">確定</button>
			</form>


</body>
</html>