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
<!--<form action ="req1.jsp" method="GET">
	username : <input type="text" name="username"><br> 
	age :<input type="text" name="age"><br>
	hobby : <input type ="checkbox" name = "hobbies" value="독서"> 책읽기
	<input type ="checkbox" name = "hobbies" value="코딩"> 코딩하기<br>
	<select name = "colors">
	<option value = "red">빨강</option>
	<option value = "blue">파랑</option>
	</select>
	<input type="submit" value="전송"><br>
</form> -->  
<form action="A.jsp" method="GET">
학번 : <input type="text" name="stu_no"><br>
이름 : <input type="text" name="stu_name"><br>
학과 : <select name = "stu_dept">
	<option value = "기계">기계</option>
	<option value = "전기전자">전기전자</option>
</select><br>
학년 : <select name = "stu_grade">
	<option value = "1">1학년</option>
	<option value = "2">2학년</option>
	<option value = "3">3학년</option>
</select><br>
반 : <select name = "stu_class">
	<option value = "A">A반</option>
	<option value = "B">B반</option>
	<option value = "C">C반</option>
</select><br>
성별 : <input type ="checkbox" name = "stu_gender" value="M"> 남자
	 <input type ="checkbox" name = "stu_gender" value="F"> 여자<br>
키 : <input type="text" name="stu_height"><br>
몸무게 : <input type="text" name="stu_weight"><br>
<input type="submit" value="전송"><br>
</form>
<a href = "student.jsp"><h2>학생목록보기</h2></a>
</body>
</html>