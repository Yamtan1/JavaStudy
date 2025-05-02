<%@page import="memberDao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="memberDao.MemberDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<form name="frm" id="frm" action="insertMember" method="POST">
	id : <input type="text" name="id"><input type="button" value="중복확인" onclick="f3()">
    <p id="idcheck"></p><br>
	pw : <input type="text" name="pw" id="pw"><br>
	pw확인 : <input type="text" name="pwcheck" id="pwcheck" onblur="f2()"><br>
	<p id="check"></p><br>
	이름 : <input type="text" name="name"><br>
	<input type="submit" value="가입" onclick="f()">
</form>


	<script>
	var result = <%= request.getAttribute("result") %>;
	
	document.getElementById("frm").addEventListener("submit", f);
	
	function f(event){
		
		event.preventDefault(); 
		const frm = document.forms['frm'];
		if(frm.id.value.trim() ===''){
			alert('id를 입력하세요');
			return;
		}
		if(frm.pw.value.trim() ===''){
			alert('pw를 입력하세요');
			return;
		}
		if(frm.pwcheck.value.trim() ===''){
			alert('pw를 확인하세요');
			return;
		}
		if(frm.name.value.trim() ===''){
			alert('이름을 입력하세요');
			return;
		}
		frm.submit();
	}
	function f2(){
		const pw = document.getElementById("pw");
		const pwcheck = document.getElementById("pwcheck");
		const check = document.querySelector("#check");
		if(pw.value == pwcheck.value){
			check.innerHTML = "<h3>비밀번호가 일치합니다.</h3>";
		}
		else{
			check.innerHTML = "<h3>비밀번호가 일치하지 않습니다!</h3>";
		}
	}
	function f3() {
		
	    const idcheck = document.querySelector("#idcheck");
	    
	    if (result === false) { 
	        idcheck.innerHTML = "<h3>사용 가능한 아이디입니다.</h3>";
	    }
		else { 
	        idcheck.innerHTML = "<h3>사용 불가능한 아이디입니다.</h3>";
	    }
	}
	</script>
</body>
</html>