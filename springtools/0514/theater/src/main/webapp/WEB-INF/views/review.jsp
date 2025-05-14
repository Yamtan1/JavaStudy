<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  font-family: 'Segoe UI', sans-serif;
  background-color: #f5f5f5;
  color: #333;
  padding: 30px;
}

h1, h3 {
  color: #333;
}

form {
  margin-bottom: 30px;
}

input[type="text"] {
  width: 60%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 6px;
}

input[type="submit"] {
  background-color: #0077cc;
  color: white;
  padding: 8px 14px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  margin-left: 10px;
}

textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 6px;
  resize: vertical;
  background-color: #fefefe;
}
</style>
</head>
<body>
<h1>후기를 작성해주세요</h1>
<hr>
<form action="writeReview" method="POST">
<input type="hidden" name="id" value="${sessionScope.loginId}">
<input type="text" name="content">
<input type="submit" value="작성" onclick="gradeCh()">
</form>
<hr>
<h3>작성된 후기</h3>
<c:forEach var="list" items="${list }">
	<hr>
	<h5>작성자 : ${list.id }</h5>
	<textarea name="answer" id="answer" rows="2" cols="50" readonly>${list.content }</textarea><br>
	<h5>작성일자 : ${list.regdate }</h5>
	<hr>
</c:forEach>

<script>
	function gradeCh(event){
		event.preventDefault(); //폼 전송을 막음
		const grade = "${sessionScoper.grade}"
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const result = xhr.responseText;
			if(result === "true") {
				// 검토 흐 후기 작성 폼을 제출
				const form = document.querySelector("form");
				form.submit();  // 자동으로 form을 제출하여 POST 요청을 보냄
			} else {
				alert("후기를 작성할 수 없습니다.");
			}
		}
		xhr.open("GET", "/reviewGrade?grade=" + grade)
		xhr.send();
	}

</script>

</body>
</html>