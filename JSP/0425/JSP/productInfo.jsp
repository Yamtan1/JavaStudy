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
<h1>제품코드조회</h1>
    <table border="1">
        <thead>
            <tr>
                <th>제품코드</th>
                <th>제품명</th>
                <th>단가</th>
                <th>할인율(10%)</th>
                <th>할인율(15%)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${product}">
                <tr>
                    <td>${p.pcode}</td>
                    <td>${p.pname}</td>
                    <td>${p.cost}</td>
                    <td>${p.discount10}</td>
                    <td>${p.discount15}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>