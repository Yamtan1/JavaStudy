<%@page import="com.example.demo.Vo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>p2 페이징</h1>
<hr>
<table border="1">
    <tr>
        <th>ID</th>
        <th>PW</th>
        <th>Name</th>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.pw}</td>
            <td>${user.name}</td>
        </tr>
    </c:forEach>
</table><br>
<a href="test">test페이지로 돌아가기</a>
<hr>
<table border="2">
    <tr>
        <th>ID</th>
        <th>PW</th>
        <th>Name</th>
    </tr>

    <% 
        // list가 모델로 전달된 User 리스트라고 가정
        List<User> list = (List<User>) request.getAttribute("list");

        // list가 null이 아니고 비어 있지 않으면 반복문을 실행
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
    %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getPw() %></td>
            <td><%= user.getName() %></td>
        </tr>
    <% 
            }
        } else {
    %>
        <tr>
            <td colspan="3">등록된 사용자 정보가 없습니다.</td>
        </tr>
    <% 
        }
    %>

</table><br>
${user }
</body>
</html>