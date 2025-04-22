<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int sum = (Integer)request.getAttribute("sum");
	int sub = (Integer)request.getAttribute("sub");
	int mul = (Integer)request.getAttribute("mul");
	int div = (Integer)request.getAttribute("div");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>계산 결과</h1>
<hr>
덧셈 값 : <%= sum %><br>
뺄셈 값 : <%= sub %><br>
곱셈 값 : <%= mul %><br>
나눗셈 값 : <%= div %><br>
</body>
</html>