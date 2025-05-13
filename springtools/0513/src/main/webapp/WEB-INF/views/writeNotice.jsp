<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항 작성</h1>
<hr>
<form action="writeNotice" method="POST">
글 제목: <input type="text" name="title"><br>
글 내용: <input type="text" name="content"><br>
작성자: <input type="text" name="write" value="${sessionScope.loginId}" readonly><br>
<input type="submit" value="작성완료">
</form>

</body>
</html>