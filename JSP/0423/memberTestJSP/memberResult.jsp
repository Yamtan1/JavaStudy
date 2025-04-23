<%@page import="memberVo.memberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 완료!!</h1>
<hr>
<%
 String id = (String)request.getAttribute("id");
String pw = (String)request.getAttribute("pw");
String name = (String)request.getAttribute("name");
String grade = (String)request.getAttribute("grade");
%>
<ul>
<li>id : <%=id %></li>
<li>pw : <%=pw %></li>
<li>name : <%=name %></li>
<li>grade : <%=grade %></li>
</ul>
</body>
</html>