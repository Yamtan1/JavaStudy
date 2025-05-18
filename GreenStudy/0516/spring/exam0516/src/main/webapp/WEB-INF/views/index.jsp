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
<h1>시험자 정보를 입력해주세요(아이디 중복가능)</h1>
<form action="/exam" method="POST">
시험자 id : <input type="text" name="id"><br>
전화번호 : <input type="text" name="phone"><br>
<input type="submit" value="시험시작">
</form>
<c:if test="${not empty error}">
<h3>${error}</h3>
</c:if>

</body>
</html>