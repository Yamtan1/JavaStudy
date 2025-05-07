<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index Page</h1>
<hr>
<h4>1. Ajax Get 요청</h4>
<button onclick="getData()">1. Ajax Get 요청</button>
<div id="demo1">---------------</div>
<hr>
<h4>2-1. Ajax Get 요청2-1 (USER정보 요청 : JSON 직접 작성)</h4>
<button onclick="getUserData()">2-1. Ajax Get 요청</button>
<div id="demo2_1">----------------------</div>
<hr>
<h4>2-2. Ajax Get 요청2-2(USER정보 요청 : Jackson 라이브러리 활용)</h4>
<button onclick="getUserData2()">2-2. Ajax Get 요청</button>
<div id="demo2_2">----------------------</div>
<hr>
<h4>3. Ajax Get 요청3(파라미터 보내기)</h4>
<button onclick="sendParameter()">3. Ajax Get 요청3</button>
<div id="demo3">--------------------</div>
<hr>
<h4>4. Ajax Get 요청4(파라미터 보내기 - 패스이용)</h4>
<button onclick="sendParameter2()">4. Ajax Get 요청4</button>
<div id="demo4">--------------------</div>
<hr>
<h4>5. Ajax Get 요청4(파라미터 보내기 - user 클래스 활용)</h4>
<button onclick="sendUserData()">5. Ajax Get 요청5</button>
<div id="demo5">---------------------</div>
<hr>
<h4>1. Ajax Post 요청</h4>
<button onclick="regData1()">1. Ajax Post 요청</button>
<div id="demo6">---------------------</div>
<hr>
<h4>2. Ajax Post 요청2 - 커맨드 객체 사용</h4>
<button onclick="regData2()">2. Ajax Post 요청2</button>
<div id="demo7">---------------------</div>
<hr>
<h4>3. Ajax Post 요청3 - JSON 데이터 전송</h4>
<button onclick="regData3()">3. Ajax Post 요청3</button>
<div id="demo8">----------------------</div>


<script>
	const demo2_1 = document.getElementById("demo2_1");
	const demo2_2 = document.getElementById("demo2_2");
	const demo3 = document.getElementById("demo3");
	const demo4 = document.getElementById("demo4");
	const demo5 = document.getElementById("demo5");
	const demo6 = document.getElementById("demo6");
	const demo7 = document.getElementById("demo7");
	const demo8 = document.getElementById("demo8");
	
	function regData3(){
		const obj = {
				name : 'Hong',
				age : 33
		}
		
		const jsonStr = JSON.stringify(obj);
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo8.innerHTML = xhr.responseText;
		}
		xhr.open('POST','req8');
		xhr.setRequestHeader('Content-type','application/json');
		xhr.send(jsonStr);
	}
	
	function regData2(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo7.innerHTML = xhr.responseText;
		}
		xhr.open('POST', 'req7');
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send('name=Jackson&age=29');
	}
	
	function regData1(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo6.innerHTML = xhr.responseText;
		}
		xhr.open('POST', 'req6');
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send('name=Jackson&age=29');
	}
	
	function sendUserData(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo5.innerHTML = xhr.responseText;
		}
		xhr.open('GET', 'req5?name=jame&age=22');
		xhr.send();
	}
	
	function sendParameter2(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo4.innerHTML = xhr.responseText;
		}
		xhr.open('GET', 'req4/Jane/33');
		xhr.send();
	}
	
	function sendParameter(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			demo3.innerHTML = xhr.responseText;
		}
		xhr.open('GET', 'req3?param=aaa');
		xhr.send();
	}
	
	function getUserData2(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const obj = JSON.parse(xhr.responseText);
			demo2_2.innerHTML = "<h3>" + obj.name + ", " + obj.age + "</h3>";
		}
		xhr.open('GET', 'req2_2');
		xhr.send();
	}
	
	function getUserData(){
		const xhr = new XMLHttpRequest();
		xhr.onload=function(){
			const obj = JSON.parse(xhr.responseText);
			document.getElementById('demo2_1').innerHTML = "<h3>" + obj.name + ", " + obj.age + "</h3>";
		}
		xhr.open('GET', 'req2_1');
		xhr.send();
	}


	function getData(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			document.getElementById('demo1').innerHTML = xhr.responseText;
		}
		xhr.open('GET', 'req1'); //첫번째는 요청방식(get, post), 두번째는 요청주소(컨트롤러 메소드 위에 입력하는 거), 세번째는 true인데 기본설정이 ture라 굳이 안적어줘도됨.
		xhr.send();
	}
</script>
</body>
</html>