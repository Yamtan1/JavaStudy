<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
    <span>환영합니다, ${sessionScope.loginId}님</span>
    <a href="/logout">로그아웃</a>
</div>
</body>
</html>