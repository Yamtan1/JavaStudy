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
<jsp:include page="index.jsp" />
<h1>점포별 주문 현황</h1>
    <table border="1">
        <thead>
            <tr>
                <th>할인점 코드</th>
                <th>제품코드</th>
                <th>제품명</th>
                <th>총주문수량</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="shoplist" items="${shopRegi}">
                <tr>
                    <td>${shoplist.shopno}</td>
                    <td>${shoplist.pcode}</td>
                    <td>${shoplist.pname}</td>
                    <td>${shoplist.amount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>