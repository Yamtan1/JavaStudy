<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String loginId = (String) session.getAttribute("loginId");
    if (loginId == null) {
%>
    <!-- 로그인 안 된 상태 -->
    <div id="header">
        <a href="/login">로그인</a> 
        <a href="/signup">회원가입</a>
    </div>
<%
    } else {
%>
    <!-- 로그인 된 상태 -->
    <div id="header">
        <span>환영합니다, <%= loginId %>님</span>
        <a href="/logout">로그아웃</a>
    </div>
<%
    }
%>

</body>
</html>