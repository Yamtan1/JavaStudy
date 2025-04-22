<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 상세정보 조회</h1>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String id = "green";
	String pw = "1234";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, id, pw);
	Statement stmt = conn.createStatement();
	String stu_no = request.getParameter("stu_no");
	ResultSet rs = stmt.executeQuery("SELECT * FROM A_STUDENT WHERE stu_no =" + "'" + stu_no + "'");
%>
<table border="2">
 <thead>
 	<tr>
 		<th>학번</th>
 		<th>이름</th>
 		<th>학과</th>
 		<th>학년</th>
 		<th>반</th>
 		<th>성별</th>
 		<th>키</th>
 		<th>몸무게</th>
 	</tr>
 </thead>
 <tbody>
 <%
 	while(rs.next()){
 %>
<tr>
	<td><%=rs.getString("stu_no")%></td>
	<td><%=rs.getString("stu_name")%></td>
	<td><%=rs.getString("stu_dept")%></td>
	<td><%=rs.getString("stu_grade")%></td>
	<td><%=rs.getString("stu_class")%></td>
	<td><%=rs.getString("stu_gender")%></td>
	<td><%=rs.getString("stu_height")%></td>
	<td><%=rs.getString("stu_weight")%></td>
</tr>
<%
 	}
%>
</tbody>
</table>
</body>
</html>