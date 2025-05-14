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
  background-color: #fff;
  color: #333;
  padding: 40px;
}

h1 {
  color: #444;
}

form {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 10px;
}

input[type="text"], textarea {
  width: 100%;
  padding: 8px;
  margin: 10px 0;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
}

input[type="submit"] {
  background-color: #0077cc;
  color: white;
  border: none;
  padding: 10px 16px;
  border-radius: 6px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #005fa3;
}
</style>
</head>
<body>
<h1>답변달기(관리자용)</h1>
<hr>
<form method="post" action="/qnaAnswerUpdate"><br>	
    작성자 : <input type="text" name="id" value="${id}"><br>
   	제목 : <input type="text" name="qtitle" value="${qtitle}"><br>
    문의 내용 : <input type="text" name="qcontent" value="${qcontent}"><br>
    작성 날짜 : <input type="text" name="qdate" value="${qdate}"><br>
    <hr>
    <label for="answer">답변 내용:</label><br>
    <textarea name="answer" id="answer" rows="5" cols="50"></textarea><br><br>
    
    <input type="submit" value="답변 등록">
</form>
</body>
</html>