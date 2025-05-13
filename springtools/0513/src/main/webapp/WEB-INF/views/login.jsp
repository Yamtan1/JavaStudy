<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 로그인 페이지</h1>
<hr>
<form action="/login" method="POST">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="text" name="pw"><br>
<input type="submit" value="로그인"> <input type="button" onclick="f()" value="회원가입">

<script>
	function f(){
		alert("회원가입 화면으로 이동합니다.");
		window.location.href = "signup";
	}
</script>
</form>
</body>
</html>