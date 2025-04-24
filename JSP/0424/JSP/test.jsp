<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %> <!-- 이 위치에 파일을 추가하겠다 라는 뜻 --><!-- 파일을 추가시키면 하나의파일로 인식함 -->
<hr>
<h2>본페이지 = ${x}</h2><!-- header.jsp에서 페이지컨텍스트로 세팅하였으나 테스트페이지에서도 나오는 걸로 확인 가능 -->
<input type="button" onclick="f()" value="클릭" />
<script>
	function f(){
		alert("버튼이 클릭됨.") //알림창
		location.href="test?name=James"; //위치를 바꿈
	}
</script>
</body>
</html>