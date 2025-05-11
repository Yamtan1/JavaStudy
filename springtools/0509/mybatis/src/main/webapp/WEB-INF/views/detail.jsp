<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Detail Page</h1>
<hr>
<form action="/modify" method="post">
	id:<input type="text" name="id" value="${member.id }" readonly><br>
	name:<input type="text" name="name" value="${member.name }"><br>
	phone:<input type="text" name="phone" value="${member.phone }"><br>
	pw:<input type="text" name="pw" value="${member.pw }"><br>
	grade:<input type="text" name="grade" value="${member.grade }"><br>
	<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
	<input type="button" onclick="delMember()" value="삭제">
</form>

<script>
	function delMember(){
		const paramId = document.querySelector('input[name=id]');
		location.href="/delete/" + paramId.value;
	}
</script>
</body>
</html>