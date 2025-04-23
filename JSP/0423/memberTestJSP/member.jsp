<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Page</h1>
<hr>
<h2>회원 가입</h2><br>
<form action="memberResult" method="GET">
아이디 : <input type="text" name="id"><br>
패스워드 : <input type="text" name="pw"><br>
이름 : <input type="text" name="name"><br>
<input type="submit" value="전송">
</form>
<hr>
<a href="storageTest.jsp?y=yyy">StorageTest 페이지로 파라미터 보내기</a>
</body>
</html>