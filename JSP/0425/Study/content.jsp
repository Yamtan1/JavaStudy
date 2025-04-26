<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
내용화면입니다<br>
<a href="sub.jsp">서브페이지로 가기</a><br>
header의 페이지영역의 값 x : ${pageScope.x }
<jsp:include page="footer.jsp" />
</body>
</html>