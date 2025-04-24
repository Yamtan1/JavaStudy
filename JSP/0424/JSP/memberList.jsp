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
 <h1>회원 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>회원 번호</th>
                <th>회원성명</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>가입일자</th>
                <th>고객등급</th>
                <th>거주지역</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="member" items="${memberList}">
                <tr>
                    <td><a href="updatePage?custno=${member.custno}&custname=${member.custname}&phone=${member.phone}&address=${member.address}&joindate=${member.joindate}&grade=${member.grade}&city=${member.city}">${member.custno}</a></td>
                    <td>${member.custname}</td>
                    <td>${member.phone}</td>
                    <td>${member.address}</td>
                    <td>${member.joindate}</td>
                    <td>${member.grade}</td>
                    <td>${member.city}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>