<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String custno =(String)request.getAttribute("custno");
	String custname =(String)request.getAttribute("custname");
	String phone =(String)request.getAttribute("phone");
	String address =(String)request.getAttribute("address");
	String joindate =(String)request.getAttribute("joindate");
	String grade =(String)request.getAttribute("grade");
	String city =(String)request.getAttribute("city");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>홈쇼핑 회원 정보 수정</h1>
<hr>
<form action=update method="GET">
회원번호 : <input type="text" name="custno" value=<%=custno %>><br>
회원성명 : <input type="text" name="custname" value=<%=custname %>><br>
회원전화 : <input type="text" name="phone" value=<%=phone %>><br>
회원주소 : <input type="text" name="address" value=<%=address %>><br>
가입일자 : <input type="text" name="joindate" value=<%=joindate %>><br>
고객등급 : <input type="text" name="grade" value=<%=grade %>><br>
도시코드 : <input type="text" name="city" value=<%=city %>><br>
<input type="submit" value="수정">
</form>
<form action="search" method="GET">
<input type="submit" value="조회">
</form>
</body>
</html>