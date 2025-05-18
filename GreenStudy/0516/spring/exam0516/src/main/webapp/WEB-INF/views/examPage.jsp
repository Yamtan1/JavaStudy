<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>남은시간: <span id="timer">20</span>초</h1>
<h1>시험페이지입니다.</h1>
<div>
<form action="doExam" method="POST" id="frm">
<h5>1. 물은 몇 도에서 끓기 시작하나요?</h5>
<input type="radio" name="q1" value="1"> 1. 0도<br>
<input type="radio" name="q1" value="2"> 2. 50도<br>
<input type="radio" name="q1" value="3"> 3. 100도<br> <!-- -->
<input type="radio" name="q1" value="4"> 4. 120도<br>
<hr>
<h5>2. 다음 중 대한민국의 삼권분립에 포함되지 않는 것은?</h5>
<input type="radio" name="q2" value="1"> 1. 행정부<br>
<input type="radio" name="q2" value="2"> 2. 입법부<br>
<input type="radio" name="q2" value="3"> 3. 사법부<br>
<input type="radio" name="q2" value="4"> 4. 지방정부<br> <!-- -->
<hr>
<h5>HTML에서 a 태그는 어떤 역할을 하나요?</h5>
<input type="radio" name="q3" value="1"> 1. 글자를 굵게만든다<br>
<input type="radio" name="q3" value="2"> 2. 표를 만든다<br>
<input type="radio" name="q3" value="3"> 3. 다른 페이지나 주소로 연결하는 링크를 만든다<br> <!-- -->
<input type="radio" name="q3" value="4"> 4. 줄을 바꾼다<br>
<hr>
<h5> 지구 온난화의 주요 원인으로 가장 적절한 것은?</h5>
<input type="radio" name="q4" value="1"> 1. 태양폭발<br>
<input type="radio" name="q4" value="2"> 2. 대기 중 이산화탄소 증가<br> <!-- -->
<input type="radio" name="q4" value="3"> 3. 달의 공전 변화<br>
<input type="radio" name="q4" value="4"> 4. 수목 증가<br>
<hr>
<h5>5. 다음 중 문학 작품이나 영화에 대한 감상을 가장 잘 표현한 문장은?</h5>
<input type="radio" name="q5" value="1"> 1. "그냥 그런 거였어요"<br>
<input type="radio" name="q5" value="2"> 2. "내용이 많았어요"<br>
<input type="radio" name="q5" value="3"> 3. "등장인물이 많았어요"<br>
<input type="radio" name="q5" value="4"> 4. "이야기의 주제가 감동적이어서 오래 기억에 남았습니다."<br> <!-- -->
<hr>
<input type="submit" value="제출" onclick="f(event)">
</form>
</div>

<script>
document.getElementById("frm").addEventListener("submit", f);

function f(event) {
    event.preventDefault();
    const frm = document.forms['frm'];
    if (frm.q1.value.trim() === '') {
        alert('모든 문항체크 후 제출해주세요');
        return;
    }
    if (frm.q2.value.trim() === '') {
    	alert('모든 문항체크 후 제출해주세요');
        return;
    }
    if (frm.q3.value.trim() === '') {
    	alert('모든 문항체크 후 제출해주세요');
        return;
    }
    if (frm.q4.value.trim() === '') {
    	alert('모든 문항체크 후 제출해주세요');
        return;
    }
    if (frm.q5.value.trim() === '') {
    	alert('모든 문항체크 후 제출해주세요');
        return;
    }
    else{
    	alert("제출이완료되었습니다.");
    }
    frm.submit();  // 폼을 제출
}
	
	let timeLeft = 20;
	let $timer = document.getElementById('timer');
	let modalShown = false;
	 const frm = document.forms['frm'];
	const interval = setInterval(() => {
		timeLeft--;
		$timer.innerText = timeLeft;
		
		if(timeLeft <= 0){
			clearInterval(interval);
			alert("시간이 종료되었습니다.");
			frm.submit();
		}
	}, 1000);
</script>
</body>
</html>