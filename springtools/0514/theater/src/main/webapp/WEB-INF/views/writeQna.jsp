<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  font-family: 'Segoe UI', sans-serif;
  background-color: #ffffff;
  color: #333;
  padding: 40px;
  max-width: 600px;
  margin: auto;
}

h1 {
  color: #222;
  margin-bottom: 20px;
}

form {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 10px;
}

input[type="text"] {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
}

input[type="submit"] {
  background-color: #0077cc;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #005fa3;
}
</style>
</head>
<body>
<h1>문의사항 작성하세용</h1>
<hr>
<form action="writeQna" method="POST">
제목: <input type="text" name="qtitle"><br>
내용: <input type="text" name="qcontent"><br>
작성자: <input type="text" name="id" value="${sessionScope.loginId}" readonly><br>
<input type="submit" value="작성완료">
</form>
</body>
</html>