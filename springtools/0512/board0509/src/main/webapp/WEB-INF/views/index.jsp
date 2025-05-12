<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 합시다</h1>
<hr>
<form action="login" method="POST">
	<input type="text" name="id"><br>
	<input type="text" name="pw"><br>
	<input type="submit" value="로그인">
	<input type="button" onclick="f()" value="회원가입">
</form>
<h2>${error}</h2>
<hr>
<a href="/boardList">게시글 목록 보기</a>
<script>
function f(){
	alert("회원가입 화면으로 이동합니다");
	window.location.href = "signup"; // signup로 이동
}
</script>
</body>
</html>