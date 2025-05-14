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
    background-color: #f0f2f5;
    font-family: 'Arial', sans-serif;
    padding: 40px;
    color: #333;
}

h1 {
    text-align: center;
    color: #4CAF50;
    margin-bottom: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    margin-bottom: 20px;
}

table th, table td {
    padding: 12px 15px;
    border-bottom: 1px solid #ccc;
    text-align: center;
}

table thead {
    background-color: #4CAF50;
    color: white;
}

table tbody tr:hover {
    background-color: #f1f1f1;
}

a {
    text-decoration: none;
    color: #2196F3;
}

a:hover {
    text-decoration: underline;
}

input[type="button"] {
    padding: 10px 20px;
    font-size: 1em;
    border: none;
    border-radius: 6px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
    transition: background 0.3s;
    margin-bottom: 20px;
}

input[type="button"]:hover {
    background-color: #45a049;
}

div {
    text-align: center;
    margin-top: 20px;
}

div a {
    margin: 0 5px;
    font-weight: bold;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>★★★★★문의사항★★★★★</h1>
<%@ include file="header2.jsp" %>
<c:if test="${not empty error}">
    <script>
        alert('${error}');
    </script>
</c:if>
<div>
<table border="1">
	<thead>
		<tr>
			<th>no</th><th>제목</th><th>작성자</th><th>작성일</th><th>답변현황</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="qna" items="${list}" varStatus="status">
		<tr>
			<td>${(currentPage - 1) * 10 + status.count}</td>	
			<td>
		    	<form id="qnaForm${status.index}" method="post" action="qnaView">
		        <input type="hidden" name="qtitle" value="${qna.qtitle}" />
		        <input type="hidden" name="id" value="${qna.id}" />
		        <input type="hidden" name="qdate" value="${qna.qdate}" />
		        <input type="hidden" name="qcontent" value="${qna.qcontent}" />
		        <a href="#" onclick="document.getElementById('qnaForm${status.index}').submit(); return false;">
		            ${qna.qtitle}
		        </a>
		   		</form>
			</td>
			<td>${qna.id }</td>
			<td>${qna.qdate }</td>
			<td>
			<c:if test="${not empty qna.answer}">
			답변완료
			</c:if>
			<c:if test="${empty qna.answer}">
			답변대기중
			</c:if>
			</td>
		<tr>
		</c:forEach>
	</tbody>
</table><br>
</div>
<input type="button" onclick="qnawrite()" value="문의사항 작성"><br>
<div>
 <c:if test="${startPage > 1}"> <!-- startpage의경우 1, 11, 21의 값만 나오기때문에 11페이지 부터 활성화 됨 -->
        <a href="/qna?page=${startPage - 1}">[이전]</a>
 </c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage }">
<a href="/qna?page=${i}">${i }</a>
</c:forEach>
<c:if test="${endPage < totalPage}">
        <a href="/qna?page=${endPage + 1}">[다음]</a>
</c:if>
</div>
</body>


<script>
function qnawrite(){
	const grade = "${sessionScope.grade}";
	const xhr = new XMLHttpRequest();
	xhr.onload = function (){
		const result = xhr.responseText;
		if(result === "true"){
			window.location.href = "writeQna";
		}
		else {
			alert("회원만 사용 가능합니다");
			window.location.href = "qna";	
		}
	}
	xhr.open('GET', 'qnaGrade?grade=' + grade);
	xhr.send();
}
</script>
</body>
</html>