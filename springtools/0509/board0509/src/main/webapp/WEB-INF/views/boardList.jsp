<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
<hr>

<table border="1">
	<thead>
		<tr>
		<th>no</th><th>게시글 제목</th><th>내용</th><th>작성자</th><th>작성일자</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="board" items="${blist}" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.write }</td>
			<td>${board.regdate }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<hr>
<input type="button" value="게시글 작성" onclick="f()">

<script>
var loginId = "${sessionScope.loginId}"; 
function f(){
	if(loginId == null || loginId === ""){
		alert("로그인해주십시오");
		window.location.href = "/"; // write로 이동
	}
	else{
		alert("게시글 작성 화면으로 이동합니다");
		window.location.href = "write"; // write로 이동	
	}
	
}
</script>
</body>
</html>