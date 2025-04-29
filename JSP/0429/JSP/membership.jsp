<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="DbCon.Dbcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* String driver = application.getInitParameter("OracleDriver");
	String url = application.getInitParameter("OracleUrl");
	String uid = application.getInitParameter("OracleId");
	String upw = application.getInitParameter("OraclePw");
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, uid, upw); */
%>
<h1>회원가입 page</h1>
<hr>
<form action="membership" method="POST">
생성할 ID : <input type="text" name="id"><br>
생성할 PW : <input type="text" name="pw"><br>
<input type="submit" value="회원가입" onclick="f()">
</form>

<script>
	function f(){
		alert("회원가입 완료") //알림창
	}
</script>
</body>
</html>