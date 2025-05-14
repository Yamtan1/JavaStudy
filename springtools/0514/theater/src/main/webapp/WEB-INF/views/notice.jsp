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
h1 {
    font-size: 2.5em;
    text-align: center;
    margin-bottom: 20px;
    color: #4CAF50;
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

th, td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

th {
    background-color: #4CAF50;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #e1e1e1;
}

/* 버튼 스타일 */
input[type="button"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 20px;
    font-size: 1.1em;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

input[type="button"]:hover {
    background-color: #45a049;
}

/* 페이지 네비게이션 스타일 */
div {
    text-align: center;
    margin-top: 20px;
}

a {
    color: #4CAF50;
    text-decoration: none;
    margin: 0 10px;
    font-size: 1.2em;
}

a:hover {
    text-decoration: underline;
}

/* 반응형 디자인 - 작은 화면에서의 레이아웃 */
@media (max-width: 768px) {
    table {
        width: 100%;
        font-size: 0.9em;
    }

    input[type="button"] {
        width: 100%;
        padding: 12px;
        font-size: 1.2em;
    }
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>★★★★★공지사항★★★★★</h1>
<%@ include file="header2.jsp" %>
<div>
<table border="1">
	<thead>
		<tr>
			<th>no</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list}" varStatus="status">
		<tr>
			<td>${(currentPage - 1) * 10 + status.count}</td>	
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.write }</td>
			<td>${board.regdate }</td>
		<tr>
		</c:forEach>
	</tbody>
</table><br>
</div>
<input type="button" id="gradeCheck" onclick="gradeCheck()" value="공지사항 작성"><br>
<div>
 <c:if test="${startPage > 1}"> <!-- startpage의경우 1, 11, 21의 값만 나오기때문에 11페이지 부터 활성화 됨 -->
        <a href="/notice?page=${startPage - 1}">[이전]</a>
 </c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage }">
<a href="/notice?page=${i}">${i }</a>
</c:forEach>
<c:if test="${endPage < totalPage}">
        <a href="/notice?page=${endPage + 1}">[다음]</a>
</c:if>
</div>


<script>
	function gradeCheck(){
		const grade = "${sessionScope.grade}";
		const xhr = new XMLHttpRequest();
		xhr.onload= function(){
			const result = xhr.responseText;
			if(result === "true"){
				window.location.href = "writeNotice";
			}
			else{
				alert("관리자만 이용할 수 있습니다.");
				window.location.href = "notice";
			}
		}
		xhr.open('GET', 'gradeCheck?grade=' + grade);
		xhr.send();
		}
</script>

</body>
</html>