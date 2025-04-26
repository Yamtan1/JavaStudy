<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="test.Man" %>
<%
    // 자바에서 객체 생성 후 request 영역에 저장
    test.Man man = new test.Man();
    request.setAttribute("member", man);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test</title>
</head>
<body>
<h1>EL & JSTL</h1>
<hr>

<!-- 같은 이름의 변수 msg를 session/page에 저장 -->
<c:set var="msg" value="Hello (Session)" scope="session"/>
<c:set var="msg" value="Hello (Page)" scope="page"/>
<p>msg : ${msg}</p>

<!-- 숫자도 c:set으로 저장 가능 -->
<c:set var="age" scope="page">30</c:set>
<p>age : ${age}</p>

<a href="jstlTest2.jsp">jstl2 페이지로 가기</a>
<hr>

<!-- JSTL로 member 객체 프로퍼티 설정 -->
<c:set target="${member}" property="name" value="James" />
<c:set target="${member}" property="age" value="33" />
<c:set target="${member}" property="job" value="학생" />

member 정보 : ${member}<br>
이름: ${member.name}, 나이: ${member.age}, 직업: ${member.job}<br>

<!-- page 영역의 msg 삭제 -->
<c:remove var="msg" scope="page" />

<p>msg (pageScope): ${pageScope.msg}</p>
<p>msg (sessionScope): ${sessionScope.msg}</p>

<hr>
<!-- 색상 선택 폼 -->
<form action="jstlTest2.jsp">
   <label for="color">색상을 선택하세요.</label>
   <select id="color" name="color">
      <option value="1">빨강</option>
      <option value="2">초록</option>
      <option value="3">파랑</option>  
   </select>
   <input type="submit" value="전송">
</form>

</body>
</html>
