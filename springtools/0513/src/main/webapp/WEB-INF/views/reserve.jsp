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
    <h2>공연 예매</h2>
    <form action="/reserve" method="post">
        <input type="text" name="title" value="${param.title}" readonly>
        날짜: <input type="date" name="choicedate" required><br><br>
        좌석 선택: <br>
        <table border="1">
        <tr>
        	<c:forEach var="i" begin="1" end="10">
        	<th><input type="checkbox" name="seats" value="A${i}">A${i}</th>
        	</c:forEach>
        </tr>
        <tr>
        	<c:forEach var="i" begin="1" end="10">
        	<th><input type="checkbox" name="seats" value="B${i}">B${i}</th>
        	</c:forEach>
        </tr>
        <tr>
        	<c:forEach var="i" begin="1" end="10">
        	<th><input type="checkbox" name="seats" value="C${i}">C${i}</th>
        	</c:forEach>
        </tr>
        </table>
        <input type="submit" value="예매하기">
    </form>
    <c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>