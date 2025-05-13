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
			<td>${board.title }</td>
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