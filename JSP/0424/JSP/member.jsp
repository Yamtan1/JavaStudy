<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int custno = 10000;%>
    <%custno++;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>홈쇼핑 회원 등록</h1>
<hr>
<form action=regi method="GET">
회원번호(자동발생) : <input type="text" name="custno" value="<%=custno %>"><br>
회원성명 : <input type="text" name="custname"><br>
회원전화 : <input type="text" name="phone"><br>
회원주소 : <input type="text" name="address"><br>
가입일자 : <input type="text" name="joindate"><br>
고객등급 : <input type="text" name="grade"><br>
도시코드 : <input type="text" name="city"><br>
<input type="submit" value="등록">
</form>
<form action="search" method="GET">
<input type="submit" value="조회/수정">
</form>
<form action="sellsearch" method="GET">
<input type="submit" value="회원매출조회">
</form>
 
</body>
</html>