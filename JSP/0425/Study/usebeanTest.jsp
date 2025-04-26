
<%@page import="test.Man"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="m" class="test.Man"> <!-- m은 참조변수  -->
<jsp:setProperty property="name" name="m" value="홍길순" /> <!--property 멤버변수 이름/ name은 id와 일치해야함  -->
<jsp:setProperty property="age" name="m" value="32" />
<jsp:setProperty property="job" name="m" param="job" />

이름 : <jsp:getProperty property="name" name="m"/> 
나이 : <jsp:getProperty property="age" name="m"/>
직업 : <jsp:getProperty property="job" name="m"/>

<%=m.getAge() %>
</jsp:useBean>
</body>
</html>