<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/fragment/header.jsp" /> <!-- 절대경로 -->
<h1>Member M1 page</h1>
<hr>
<jsp:include page="../fragment/footer.jsp" /> <!-- 상대경로 --> 

</body>
</html>