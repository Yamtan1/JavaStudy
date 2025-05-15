<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#sessionModal{
		display: none;
		position: fixed;
		z-index: 9999;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.4);
	}
		
	#modalContent{
		background-color: white;
		margin: 20% auto;
		padding: 20px;
		width: 300px;
		text-align: center;
		border-radius: 10px;
	}
</style>
</head>
<body>
<h1>세션 카운트 다운: <span id="timer">60</span>초</h1>

<!-- 모달 -->
<div id="sessionModal">
	<div id="modalContent">
		<p>세션이 곧 만료됩니다. 연장하시겠습니까?</p>
		<button onclick="extendSession()">연장</button>
		<button onclick="logout()">로그아웃</button>
	</div>
</div>


<!-- <h1>세션테스트</h1>
<div id="demo"></div>  -->

<script>
	/* let cnt = 10;
	const interval = setInterval(() => {
		const demo = document.getElementById('demo');
		cnt--;
		demo.innerHTML = cnt;
		if(cnt === 0){
			clearInterval(interval);
			window.location.href = "/logout";
		}
	}, 1000); */
	let timeLeft = 60;
	let $timer = document.getElementById('timer');
	let modalShown = false;
	
	const interval = setInterval(() => {
		timeLeft--;
		$timer.innerText = timeLeft;
		
		if(timeLeft === 10 && !modalShown){
			document.getElementById("sessionModal").style.display = "block";
			modalShown = true;
		}
		if(timeLeft <= 0){
			clearInterval(interval);
			logout();
		}
	}, 1000);
	function extendSession(){
		fetch("/extend-session", {
			method: "POST"
		})
		.then(() => {
			timeLeft = 60;
			modalShown =false;
			document.getElementById("sessionModal").style.display = "none";
		});
	}
	function logout(){
		window.location.href = "/logout";
	}
</script>
</body>
</html>