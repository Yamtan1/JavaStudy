<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadProc" method="POST" enctype="multipart/form-data"> <!-- 파일 업로드할때 반드시 써줘야함(enctype) -->
	<input type="text" name="desc" placeholder="파일설명"><br>
	<input type="file" name="imgfile"><br>
	<input type="submit" value="업로드">
</form>
</body>
</html>