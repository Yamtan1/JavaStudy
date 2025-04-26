<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>msg(session) : ${msg }</p>
<p>age(page) : ${age }</p>
<hr>
<c:if test= "${param.color == 1}">
	<span style ="color: red;"> 빨강</span>
</c:if>
<c:if test= "${param.color == 2}">
	<span style ="color: green;"> 초록</span>
</c:if>
<c:if test= "${param.color == 3}">
	<span style ="color: blue;"> 파랑</span>
</c:if>
</body>
</html>