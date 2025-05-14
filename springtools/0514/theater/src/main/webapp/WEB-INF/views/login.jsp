<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    background-color: #f0f2f5;
    font-family: 'Arial', sans-serif;
    color: #333;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px;
}

h1 {
    color: #4CAF50;
    margin-bottom: 20px;
}

form {
    background: white;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 100%;
    max-width: 400px;
}

input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 1em;
}

input[type="submit"], input[type="button"] {
    width: 48%;
    padding: 10px;
    border: none;
    border-radius: 6px;
    font-size: 1em;
    cursor: pointer;
    transition: background 0.3s;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
}

input[type="button"] {
    background-color: #2196F3;
    color: white;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

input[type="button"]:hover {
    background-color: #1976D2;
}
</style>
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