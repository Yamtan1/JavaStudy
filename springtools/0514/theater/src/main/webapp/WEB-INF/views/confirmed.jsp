<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  font-family: 'Segoe UI', sans-serif;
  background-color: #f9f9f9;
  color: #333;
  padding: 30px;
}

h1 {
  color: #0066cc;
}

br {
  display: block;
  margin: 10px 0;
}
</style>
</head>
<body>
<h1>예매가 완료되었습니다.</h1>
예매한 공연 : ${title }<br>
예매날짜 : ${date }<br>
예매 좌석 :
<c:forEach var="seat" items="${seats}">
    ${seat}
</c:forEach>
<br>
</body>
</html>