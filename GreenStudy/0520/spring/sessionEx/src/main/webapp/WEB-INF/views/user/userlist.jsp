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
<h1>User List Page</h1>
<hr>
<table border="1">
	<thead>	
		<tr>	
			<th>no</th><th>id</th><th>name</th><th>role</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.role }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr>
<table border="1">
	<thead>	
		<tr>	
			<th>no</th><th>id</th><th>name</th><th>role</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user2" items="${user2 }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user2.id }</td>
				<td>${user2.name }</td>
				<td>${user2.role }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>