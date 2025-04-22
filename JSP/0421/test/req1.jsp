<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //스크립트 릿 (함수 안에다 코드를 쓰는 것과 같음)
	//http://localhost:8080/test/req1.jsp?username=aaa&age=11&hobbies=독서&hobbies=코딩&colors=red
	//request는 내장 객체이다 따로 생성을 해주지 않아도 된다 request. 으로 바로 사용
	String param1 = request.getParameter("username");
	String param2 = request.getParameter("age");
	String[] hobbies = request.getParameterValues("hobbies"); //값이 여러개 이므로 배열사용
	String colors = request.getParameter("colors");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 body{
 background-color : <%=colors %>;
 }
</style>
</head>
<body>
<h1>REQ1 Page</h1>
<hr>
username = <%=param1 %><br>
age = <%=param2 %> <br>
hobby1 = <%=hobbies[0] %><br>
hobby2 = <%=hobbies[1] %><br>
</body>
</html>