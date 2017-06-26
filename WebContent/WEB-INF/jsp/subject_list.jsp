<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目一覧</title>
</head>
<body>



<%
  ArrayList<String> arr = request.getAttribute("subjects");

   int flg =111;

   for (int i=0; i<arr.size(); i++) {
       String sbg = subject.getSub_group(i);

       if(flg%10 == 1){}

       if (sbg.equals("IT")) {
           // ITの場合

       } else if (sbg.equals("English")){

       } else if (sbg.equals("communication")){

       }
   }
%>

</body>
</html>