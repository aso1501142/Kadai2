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
<form method="post" action="Subject_list">
<ul>

	<c:forEach var="stu" items="${stu}">
			<li><c:out value="${stu.stu_name}"></c:out></li>
	</c:forEach>

</ul>

<input type="submit" value="戻る">

</form>
</body>
</html>