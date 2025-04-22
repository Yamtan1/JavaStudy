<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String id = "green";
	String pw = "1234";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, id, pw);
	Statement stmt = conn.createStatement();
	String stu_no = request.getParameter("stu_no");
	String stu_name = request.getParameter("stu_name");
	String stu_dept = request.getParameter("stu_dept");
	String stu_grade = request.getParameter("stu_grade");
	String stu_class = request.getParameter("stu_class");
	String stu_gender = request.getParameter("stu_gender");
	String stu_height = request.getParameter("stu_height");
	String stu_weight = request.getParameter("stu_weight");
	
	String query = "INSERT INTO A_STUDENT VALUES ( "
					+ "'" + stu_no + "', "
					+ "'" + stu_name + "', "
					+ "'" + stu_dept + "', "
					+ stu_grade + "," 
					+ "'" + stu_class + "', "
					+ "'" + stu_gender + "', "
					+ stu_height + ", "
					+ stu_weight + ")";
	
	int result = stmt.executeUpdate(query);
			 
	
    response.sendRedirect("B.jsp");
    %>
