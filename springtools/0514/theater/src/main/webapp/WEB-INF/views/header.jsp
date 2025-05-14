<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
}

/* 헤더 공통 스타일 */
#header, #header2 {
    background-color: #4CAF50;
    color: white;
    padding: 10px 0;
    text-align: center;
}

#header a, #header2 a {
    color: white;
    text-decoration: none;
    padding: 10px 20px;
    font-size: 1.1em;
    margin: 0 10px;
    transition: background-color 0.3s ease, color 0.3s ease;
}

/* 로그인/회원가입 영역의 스타일 */
#header a {
    background-color: #4CAF50;
    border-radius: 5px;
}

#header a:hover {
    background-color: #45a049;
}

/* 공지사항, 이벤트, 문의사항 영역의 스타일 */
#header2 a {
    background-color: #333;
    border-radius: 5px;
}

#header2 a:hover {
    background-color: #444;
}

/* 로그인 상태일 때 "환영합니다" 텍스트 스타일 */
#header span {
    font-size: 1.2em;
    font-weight: bold;
}

/* 반응형 디자인 - 작은 화면에서의 레이아웃 */
@media (max-width: 768px) {
    #header, #header2 {
        text-align: left;
        padding: 15px;
    }

    #header a, #header2 a {
        display: block;
        margin: 5px 0;
    }
}
</style>
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