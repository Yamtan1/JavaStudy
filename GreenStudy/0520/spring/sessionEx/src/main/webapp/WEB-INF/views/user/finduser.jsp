<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user/finduser" method="POST">
	이름: <input type="text" name="name"><br>
	등급: <input type="text" name="role"><br>
	<input type="submit" value="찾기">
</form>
</body>
</html>