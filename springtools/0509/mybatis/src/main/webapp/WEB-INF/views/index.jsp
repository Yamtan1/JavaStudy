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
<a href="/list">회원목록보기</a>
<hr>
<h1>회원등록합시당</h1><br>
<form action="/insert" method="post">
	id : <input type="text" name="id"><br>
	name : <input type="text" name="name"><br>
	phone : <input type="text" name="phone"><br>
	pw : <input type="text" name="pw"><br>
	grade : <input type="text" name="grade"><br>
	<input type="submit" value="가입">
</form>
</body>
</html>