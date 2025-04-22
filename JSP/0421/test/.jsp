<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<h1>학생 목록</h1>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String id = "green";
	String pw = "1234";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, id, pw);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM A_STUDENT");
%>
<table border="1">
 <thead>
 	<tr>
 		<th>학번</th>
 		<th>이름</th>
 	</tr>
 </thead>
 <tbody>
 <%
 	while(rs.next()){
 %>
<tr>
	<td> <%=rs.getString("stu_no")%></td>
	<td> <%=rs.getString("stu_name")%></td>
</tr>
<%
 	}
%>
</tbody>
</table>
</body>
</html>