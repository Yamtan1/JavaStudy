<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 pageContext.setAttribute("x","page_X"); //이페이지에만 유효한 저장소
 request.setAttribute("x", "request_X"); // 다른 페이지로 복사가능
 session.setAttribute("x", "session_X"); // 브라우저에 귀속됨 사용자에 귀속 개인화된 저장소
 application.setAttribute("x", "application_X"); // 이 프로젝트, 서비스를 이용하는 모든사람들이 공유할 수 있는 저장소
 String s = "hello";
 
 pageContext.setAttribute("s",s);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
page 저장소 값 : <%= pageContext.getAttribute("x") %><br>
request 저장소 값 : <%= request.getAttribute("x") %><br>
session 저장소 값 <%= session.getAttribute("x") %><br>
application 저장소 값 <%= application.getAttribute("x") %>
<hr>
page 저장소 값 : ${pageScope.x }<br> 
request 저장소 값 : ${requestScope.x }<br>
session 저장소 값 : ${sessionScope.x }<br>
application 저장소 값 : ${applicationScope.x }<br>
<hr>
s(EL표기법) : ${s }
s(자바표현법) : <%=s %>
<hr>
파라미터 y : ${param.y }<br>
</body>
</html>