<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>p2 Page</h1>
<hr>
<%
//String name = request.getParameter("name");
//String age = request.getParameter("age");
	String name = (String)request.getAttribute("x");
	String age = (String)request.getAttribute("y");
%>
name 파라미터 값 : <%=name%><br>
age 파라미터 값 : <%=age%><br>
</body>
</html>