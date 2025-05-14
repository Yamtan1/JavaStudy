<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Arial', sans-serif;
}

/* body 스타일 */
body {
    background-color: #f4f4f9;
    color: #333;
    line-height: 1.6;
    padding: 20px;
}

/* 제목 스타일 */
h2 {
    font-size: 2em;
    text-align: center;
    margin-bottom: 30px;
    color: #4CAF50;
}

/* 폼 스타일 */
form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    margin: 0 auto;
}

/* 입력 필드 스타일 */
input[type="text"], input[type="date"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 1.1em;
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
    background-color: #4CAF50;
    color: white;
}

td {
    padding: 10px;
    text-align: center;
}

input[type="checkbox"] {
    margin: 5px;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

/* 제출 버튼 스타일 */
input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 12px 20px;
    font-size: 1.1em;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
    width: 100%;
    margin-top: 20px;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

/* 오류 메시지 스타일 */
p {
    text-align: center;
    font-size: 1.1em;
}

/* 반응형 디자인 - 작은 화면에서의 레이아웃 */
@media (max-width: 768px) {
    form {
        width: 90%;
        padding: 15px;
    }

    h2 {
        font-size: 1.5em;
    }

    input[type="text"], input[type="date"], input[type="submit"] {
        font-size: 1em;
    }
}
</style>
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