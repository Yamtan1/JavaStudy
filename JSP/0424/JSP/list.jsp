<%@page import="Apackage.A"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%! int gn = 1;%> <%--  스크립틀릿 ! 가 붙으면 전역변수--%> 

<%	
	int ln = 1; //여기안에 있는 애들은 멤버메서드영역(지역) 안에 들어가있음
	gn++;
	ln++;
	List<A> list = new ArrayList<>();
	list.add(new A("홍길동", 23));
	list.add(new A("홍길동2", 24));
	list.add(new A("홍길동3", 25));
	
	pageContext.setAttribute("list", list);
%> <%--  정의문 (정의한다), --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
gn : <%=gn %> <!-- 전역변수는 새로고침하면 계속 증가함 -->
ln : <%=ln %> <!-- 지역변수는 고정 -->
<!-- 주석 --> 
<%-- 주석 --%>
<table border="1">
<thead>
	<tr>
		<th>no</th><th>name</th><th>age</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="a" items="${list }" varStatus="status">
	<tr>
		<td>${status.count }</td>
		<td>${a.name }</td>
		<td>${a.age }</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>