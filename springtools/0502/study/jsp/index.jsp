<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>
<hr>
<a href="list">리스트 목록으로 가기</a>
<form action="/testList" method="get">
	<input type="text" name="id">
	<button type="submit">조회</button>
</form>
</body>
</html>