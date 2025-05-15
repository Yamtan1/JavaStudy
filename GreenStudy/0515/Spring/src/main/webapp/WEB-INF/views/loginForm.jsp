<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
<hr>
<form action="/login" method="POST">
아이디: <input type="text" name="id">
패스워드: <input type="text" name="pw">
<input type="submit" value="로그인">
</form>
<c:if test="${param.logout == 'true'}">
    <h3>로그아웃 되었습니다.</h3>
</c:if>
<c:if test="${not empty error}">
    <h3>${error }</h3>
</c:if>
</body>
</html>