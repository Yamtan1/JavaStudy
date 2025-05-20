<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 등록</h1>
<hr>
<form action="regboard" method="POST">
제목:<input type="text" name="title"><br>
내용:<input type="text" name="content"><br>
작성자:<input type="text" name="writer"><br>
작성날짜:<input type="text" name="regdate"><br>
<input type="submit" value="게시글 등록">
</form>

</body>
</html>