<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
  <script>
  	function f(){
  		$.ajax({
  			url : '/api/data',
  			type : 'GET',
  			success: function(response){
  				console.log('GET 성공:', response);
  				$('#demo').html(response);
  			},
  			error : function(xhr){
  				console.error('GET실패',xhr);
  			}
  		});
  	}
  	
  	function f2(){
  		$.ajax({
  			url : '/api/post',
  			type : 'POST',
  			contentType : 'application/json',
  			data : JSON.stringify({
  				name : '홍길동',
  				age : 30
  			}),
  			success : function(response){
  				console.log('POST(JSON) 성공:', response);
  				$('#demo').html(response);
  			},
  			error : function(xhr){
  				console.error('POST(JSON) 실패:', xhr);
  			}
  		});
  	}
  </script>
</head>
<body>
<h1>연습중</h1>
<input type="button" value="get방식" onclick="f()">
<input type="button" value="post방식" onclick="f2()">
<div id="demo">----</div>
</body>
</html>