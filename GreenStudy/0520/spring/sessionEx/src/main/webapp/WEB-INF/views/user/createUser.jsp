<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>유저 등록 페이지</h1>
<form action="/user/create" method="POST">
	아이디 :<input type="text" name="id"><br>
	비밀번호 :<input type="text" name="pw"><br>
	이름 : <input type="text" name="name"><br>
	등급 :<input type="text" name="role"><br>
	<input type="submit" value="둥록"><br>
</form>
</body>
</html>