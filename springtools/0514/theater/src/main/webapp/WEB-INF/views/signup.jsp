<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    background-color: #f0f2f5;
    font-family: 'Arial', sans-serif;
    color: #333;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px;
}

h1 {
    color: #4CAF50;
    margin-bottom: 20px;
}

form {
    background: white;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    width: 100%;
    max-width: 500px;
}

input[type="text"], select {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 1em;
}

input[type="button"], input[type="submit"] {
    padding: 10px 20px;
    margin-top: 10px;
    border: none;
    border-radius: 6px;
    font-size: 1em;
    cursor: pointer;
    transition: background 0.3s;
}

input[type="button"] {
    background-color: #2196F3;
    color: white;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    width: 100%;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

input[type="button"]:hover {
    background-color: #1976D2;
}

div#idcheck, div#pwcheck {
    margin-bottom: 10px;
    font-size: 0.9em;
    color: #d32f2f;
}
</style>
</head>
<body>
<h1>회원가입 페이지</h1>
<hr>
<form action="signup" method="POST" id="frm"> 
 아이디 : <input type="text" name="id"><input type="button" onclick="idcheck()" value="아이디 중복확인"><br>
 <div id="idcheck">---------</div>
 패스워드 : <input type="text" name="pw" id="pw"><br>
 패스워드확인 : <input type="text" name="pw2" id="pw2" onblur="pwcheck()"><br>
 <div id="pwcheck">----------</div>
 이름 : <input type="text" name="name"><br>
 전화번호 : <input type="text" name="phone"><br>
 등급 : <select id="grade" name="grade">
        <option value="관리자">관리자</option>
        <option value="회원">회원</option>
    </select>
 <input type="submit" value="회원가입" onclick="f(event)">
</form>

<script>
	
	let IdChecked = false;  // 아이디 중복 확인 여부
	let PwMatched = false;  // 비밀번호 일치 여부
	
	function idcheck(){
		const id = document.forms['frm'].id.value;
		const idcheck = document.getElementById("idcheck");
		// 정규표현식: 첫 글자는 숫자 제외 + 총 8자 이상
	    const idRegex = /^[^\d][a-zA-Z0-9]{7,}$/;

	    // 먼저 형식 검사
	    if (!idRegex.test(id)) {
	        idcheck.innerHTML = "❌ 아이디는 숫자로 시작할 수 없으며, 8자 이상이어야 합니다.";
	        IdChecked = false;
	        return;  // 서버에 요청 안 보냄
	    }
		
		const xhr = new XMLHttpRequest();
		xhr.onload=function(){
			if(xhr.responseText == 0){
				idcheck.innerHTML = "사용 가능한 아이디 입니다";
				IdChecked = true;
			}
			else{
				idcheck.innerHTML = "사용 불가능한 아이디 입니다.";
				IdChecked = false;
			}
		}
		xhr.open('GET', 'idcheck?id=' + id);
		xhr.send();
	}
	
	function pwcheck() {
	    const pw = document.getElementById("pw");
	    const pwcheck = document.getElementById("pw2");
	    const check = document.querySelector("#pwcheck");
	    const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]).{8,}$/;
	    
	    if (!pwRegex.test(pw.value)) {
	        check.innerHTML = "<h3>비밀번호는 최소 8자리 이상, 문자, 숫자, 특수문자가 포함되어야 합니다.</h3>";
	        return; // 비밀번호가 조건을 만족하지 않으면 함수 종료
	    }
	    
	    
	    if (pw.value === pw2.value) {
	        check.innerHTML = "<h3>비밀번호가 일치합니다.</h3>";
	        PwMatched = true;
	    } else {
	        check.innerHTML = "<h3>비밀번호가 일치하지 않습니다!</h3>";
	        PwMatched = false;
	    }
	}
	
	document.getElementById("frm").addEventListener("submit", f);
	
	function f(event) {
	    event.preventDefault();
	    const frm = document.forms['frm'];
	    if (frm.id.value.trim() === '') {
	        alert('id를 입력하세요');
	        return;
	    }
	    if (frm.pw.value.trim() === '') {
	        alert('pw를 입력하세요');
	        return;
	    }
	    if (frm.pw2.value.trim() === '') {
	        alert('pw를 확인하세요');
	        return;
	    }
	    if (frm.name.value.trim() === '') {
	        alert('이름을 입력하세요');
	        return;
	    }
	    if (frm.phone.value.trim() === '') {
	        alert('전화번호를 입력하세요');
	        return;
	    }
	    if (!IdChecked) {
	        alert("아이디 중복 확인을 해주세요.");
	        return;
	    }
	    if (!PwMatched) {
	        alert("비밀번호가 일치하지 않습니다.");
	        return;
	    }
	    else{
	    	alert("회원가입이 완료 되었습니다");
	    }
	    frm.submit();  // 폼을 제출
	}
</script>
</body>
</html>