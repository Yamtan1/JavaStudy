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
<% String loginId = (String) session.getAttribute("loginId"); %>
<% if (loginId != null) { %>
    <div>
        <span><%= loginId %>님 환영합니다.</span>
        <a href="/logout">로그아웃</a>
    </div>
<% } %>
<h1>게시판 목록</h1>
<hr>
<!-- 페이지 번호 출력 (고정 1~10) -->
<table border="1">
    <thead>
        <tr>
            <th>no</th>
            <th>게시글 제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일자</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="board" items="${blist}" varStatus="status">
            <tr>
                <td>${(currentPage - 1) * 10 + status.count}</td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.write}</td>
                <td>${board.regdate}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- 게시글 작성 버튼 -->
<hr>
<input type="button" value="게시글 작성" onclick="f()">

<div style="margin-top: 20px;">
    <!-- 이전 페이지 버튼 -->
    <c:if test="${startPage > 1}"> <!-- startpage의경우 1, 11, 21의 값만 나오기때문에 11페이지 부터 활성화 됨 -->
        <a href="/boardList?page=${startPage - 1}">[이전]</a>
    </c:if>

    <!-- 페이지 번호 출력 -->
    <c:forEach begin="${startPage}" end="${endPage}" var="i"> <!-- 반복문을 통해 i에는 이미 값이 다들어간 상태 -->
        <c:choose>
            <c:when test="${i == currentPage}"> <!-- 현재 페이지와 i의값이 같을때 -->
                <strong>[${i}]</strong>  <!-- 강조표시 -->
            </c:when>
            <c:otherwise> <!-- choose블록문 안에 eles문같은 역할 i == currentPage가 아닐때 실행됨 -->
                <a href="/boardList?page=${i}">[${i}]</a>
                <!-- i가 지금 보고 있는 페이지 번호와 다를 경우 그 숫자를 [링크]로 만들어서 클릭 가능하게 해줌 -->
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <!-- 다음 페이지 버튼 -->
    <c:if test="${endPage < totalPages}">
        <a href="/boardList?page=${endPage + 1}">[다음]</a>
    </c:if>
</div>

<script>
var loginId = "${sessionScope.loginId}"; 
function f(){
	if(loginId == null || loginId === ""){
		alert("로그인해주십시오");
		window.location.href = "/"; 
	}
	else{
		alert("게시글 작성 화면으로 이동합니다");
		window.location.href = "write"; // write로 이동	
	}
	
}
</script>
</body>
</html>