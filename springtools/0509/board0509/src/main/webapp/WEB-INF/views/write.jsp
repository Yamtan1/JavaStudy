<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>게시글 작성</h2>

    <form action="/write" method="post">
        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required><br><br>
        </div>
        
        <div>
            <label for="content">내용:</label><br>
            <textarea id="content" name="content" rows="10" cols="50" required></textarea><br><br>
        </div>

        <!-- 작성자는 세션에서 자동으로 채워짐 -->
        <input type="hidden" name="write" value="${sessionScope.loginId}">

        <button type="submit">작성하기</button>
    </form>

    <br>
    <a href="/boardList">게시글 목록으로 돌아가기</a>
</body>
</html>