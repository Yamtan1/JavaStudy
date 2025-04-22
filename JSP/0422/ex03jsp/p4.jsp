<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>p4 Page</h1>
<hr>
<%
 String fruit = (String)request.getAttribute("fruit");
 String subject = (String)request.getAttribute("subject");
 String animal = (String)request.getAttribute("animal");
 String[] movies = (String[])request.getAttribute("movies");
%>

내가 제일 종아하는 과일은 <%=fruit %>입니다.<br>
내가 제일 종아하는 과일은 <%=subject %>입니다.<br>
내가 제일 종아하는 과일은 <%=animal %>입니다.<br>
내가 좋아하는 영화는
<ul>
<%
	for(int i = 0; i < movies.length; i++){
%>
	<li><%= movies[i]%></li>
<%
	}
%>
</ul>
입니다

</body>
</html>
