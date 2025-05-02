<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index page</h1>
<hr>
<a href="p1?name=James">p1페이지로 가기</a>
<hr>
<form action="p2" method="POST">
	id: <input type="text" name="id">
	pw: <input type="text" name="pw">
	name: <input type="text" name="name">
<input type="submit" value="전송">
</form>
<hr>
<form action="p3" method="GET">
	id: <input type="text" name="id">
	pw: <input type="text" name="pw">
<input type="submit" value="전송">
</form>
<hr>
<a href="p3/aaa/1234">PathVariable로 파라미터 처리하기</a>
</body>
</html>