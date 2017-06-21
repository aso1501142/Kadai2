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

	<form method="post" action="">

		<h1>登録科目確認</h1>

		<p>
			科目ID:
			<c:out <%request.getAttribute("zemiId");%> />
			科目名:
			<c:out <%request.getAttribute("zemiName");%> />
			科目分類名:
			<c:out <%request.getAttribute("zemiGroup");%> />

			<a href="zemi_add.jsp" tabindex="-1">
			<input name="back" type="button"value="戻る">
			</a>
			<input type="submit" value="登録"/>
	</form>



</body>
</html>