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
<h1>주문 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>할인점 코드</th>
                <th>점포명</th>
                <th>주문번호</th>
                <th>주문일자</th>
                <th>제품코드</th>
                <th>제품명</th>
                <th>주문수량</th>
                <th>단가</th>
                <th>소비자가격</th>
                <th>할인가격</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="orderList" items="${orderL}">
                <tr>
                    <td>${orderList.shopno}</td>
                    <td>${orderList.shopname}</td>
                    <td>${orderList.orderno}</td>
                    <td>${orderList.orderdate}</td>
                    <td>${orderList.pcode}</td>
                    <td>${orderList.pname}</td>
                    <td>${orderList.amount}</td>
                    <td>${orderList.cost}</td>
                    <td>${orderList.originalPrice}</td>
                    <td>${orderList.discountPrice}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>