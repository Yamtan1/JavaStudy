
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 //1.파라미터 받기
 	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
 //2. DB접속하기
 	Class.forName("oracle.jdbc.driver.OracleDriver");
 
 	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
 	String id = "green";
 	String pw = "1234";
 	
 	Connection conn = DriverManager.getConnection(url, id, pw);
 	
 	
 
 //3. 쿼리 실행하기
 	String query = "INSERT INTO tbl_board VALUES (seq_board.nextval, ?, ?, ?, SYSDATE)";
 	PreparedStatement pstmt = conn.prepareStatement(query);
 	
 	pstmt.setString(1, title);
 	pstmt.setString(2, content);
 	pstmt.setString(3, writer);
 	
 	int result = pstmt.executeUpdate();
 	System.out.println("result : " + result);
 //4. 페이지 이동하기
 	response.sendRedirect("web.jsp");
%>    
