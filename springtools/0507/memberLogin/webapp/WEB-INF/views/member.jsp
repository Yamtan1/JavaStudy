<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<form name="frm" id="frm" action="success" method="POST">
	id : <input type="text" name="id">
	<button type="button" onclick="check()">아이디 중복 확인</button>
    <div id="idcheck">-----</div><br>
	pw : <input type="text" name="pw" id="pw"><br>
	pw확인 : <input type="text" name="pwcheck" id="pwcheck" onblur="f2()"><br>
	<p id="check"></p><br>
	이름 : <input type="text" name="name"><br>
	<input type="submit" value="가입" onclick="f()">
	</form>
	
	<script>
	const idcheck = document.getElementById("idcheck")
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
	
	function check() {
		const id = document.forms['frm'].id.value; //아이디 값 받아오기
		
		if(id.trim() === ""){
			alert("아이디를 입력하세요.");
			return;
		}
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			idcheck.innerHTML = xhr.responseText;
		}
		xhr.open('GET', 'idcheck?id='+ id );
		xhr.send();
	}

	</script>

</body>
</html>