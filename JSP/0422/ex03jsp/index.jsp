<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>
<hr>
<h2>GET 방식1 - a 태그 활용</h2>
<a href="p1.jsp">p1 페이지로 가기(jsp로 바로 연결)</a><br>
<a href="p1">p1 페이지로 가기(Servlet 통해 연결)</a>
<hr>
<h2>GET 방식2 - a 태그 활용(파라미터 보내기 --> 쿼리스트링 만들기)</h2>
<a href="p2.jsp?name=James&age=26">p2 페이지로 가기(jsp로 바로 연결)</a><br>
<a href="p2?name=James&age=26">p2 페이지로 가기(Servlet 통해 연결)</a>
<hr>
<h2>GET 방식3 - form 활용(쿼리스트링 자동 생성)</h2>
<form action="p3.jsp" method="GET">
	<!-- ?fruit=apple&subject=JAVA&animal=CAT&movies=....&movies=.... (쿼리스트링) -->
 	<input type="text" name="fruit" value="apple"><br>
	<input type="radio" name="subject" value="JAVA">JAVA
	<input type="radio" name="subject" value="SQL">SQL
	<input type="radio" name="subject" value="HTML/CSS">HTML/CSS<br>
	<select name="animal">
		<option value = "dog"> 강아지 </option> 
		<option value = "cat"> 고양이 </option>
		<option value = "tiger"> 호랑이 </option>
	</select><br>
	<input type="checkbox" name="movies" value="Taxi Driver">택시드라이버
	<input type="checkbox" name="movies" value="Iron man">아이언맨
	<input type="checkbox" name="movies" value="spider man">스파이더맨
	<input type="checkbox" name="movies" value="The God Father">대부
	<input type="submit" value="전송">
</form>
<h2>GET 방식3 - form 활용(쿼리스트링 자동 생성)----- 서블릿 활용</h2>
<form action="p4" method="GET">
	<!-- ?fruit=apple&subject=JAVA&animal=CAT&movies=....&movies=.... (쿼리스트링) -->
 	<input type="text" name="fruit" value="apple"><br>
	<input type="radio" name="subject" value="JAVA">JAVA
	<input type="radio" name="subject" value="SQL">SQL
	<input type="radio" name="subject" value="HTML/CSS">HTML/CSS<br>
	<select name="animal">
		<option value = "dog"> 강아지 </option> 
		<option value = "cat"> 고양이 </option>
		<option value = "tiger"> 호랑이 </option>
	</select><br>
	<input type="checkbox" name="movies" value="Taxi Driver">택시드라이버
	<input type="checkbox" name="movies" value="Iron man">아이언맨
	<input type="checkbox" name="movies" value="spider man">스파이더맨
	<input type="checkbox" name="movies" value="The God Father">대부
	<input type="submit" value="전송">
</form>
</body>
</html>
