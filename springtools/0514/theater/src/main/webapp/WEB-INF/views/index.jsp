<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Arial', sans-serif;
}

/* 배경 및 텍스트 스타일 */
body {
    background-color: #f4f4f9;
    color: #333;
    line-height: 1.6;
}

/* 헤더 스타일 */
header {
    background-color: #4CAF50;
    color: white;
    padding: 1em 0;
    text-align: center;
}

h1 {
    font-size: 2.5em;
    margin-bottom: 0.5em;
    text-align: center;
}

/* 구분선 스타일 */
hr {
    border: 0;
    border-top: 2px solid #4CAF50;
    margin: 1em 0;
}

/* 컨테이너 스타일 */
#container {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
    padding: 20px;
}

/* 각 카드 스타일 */
#container > div {
    width: 300px;
    height: auto; /* 고정 높이 지정 */
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    background-color: white;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 15px;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

/* 카드 이미지 스타일 */
#container img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-radius: 8px;
}

/* 카드 제목 */
#container h3 {
    font-size: 1.5em;
    color: #333;
    margin-bottom: 10px;
    text-align: center;
}

/* 카드 설명 텍스트 */
#container p {
    font-size: 1em;
    color: #777;
    text-align: center;
    margin-bottom: 20px;
}

/* 버튼 그룹 스타일 */
.btn-group {
    display: flex;
    justify-content: space-between;
    gap: 10px;
}

/* 버튼 기본 스타일 */
input[type="button"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 15px;
    font-size: 1em;
    cursor: pointer;
    border-radius: 4px;
    transition: background-color 0.3s ease;
    width: 100%;
}

/* 버튼 호버 효과 */
input[type="button"]:hover {
    background-color: #45a049;
}

/* 카드 hover 효과 */
#container > div:hover {
    transform: translateY(-5px);
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
}

/* 버튼을 텍스트와 맞추기 위한 스타일 */
input[type="button"]:nth-child(1) {
    width: 48%;
}

input[type="button"]:nth-child(2) {
    width: 48%;
}

/* 반응형 디자인 - 작은 화면에서의 레이아웃 */
@media (max-width: 768px) {
    #container {
        flex-direction: column;
        align-items: center;
    }
    
    #container > div {
        width: 90%;
    }
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Curtain Call</h1>
<hr>
<%@ include file="header2.jsp" %>
<div id="container">
	<div>
	<h3>현재 공연 중인 작품</h3>
	<img src="https://search.pstatic.net/common?type=f&size=224x338&quality=100&direct=true&src=https%3A%2F%2Fcsearch-phinf.pstatic.net%2F20250408_196%2F1744102181763MUH3f_JPEG%2F269_36749853_image_url_1744102181675.jpg"><br>
	<p>BIPAF KIDS PROGRAM [테일러 메이드] - 부산</p><br>
	<div class="btn-group">
			<input type="button" value="상세정보" onclick="location.href='tailerMade'">
			<input type="button" value="예매하기" onclick="location.href='reserve?title=테일러 메이드'">
	</div>
	</div>
	<div>
	<h3>공연 예정 작품</h3>
	<img src="https://search.pstatic.net/common?type=f&size=224x338&quality=100&direct=true&src=https%3A%2F%2Fcsearch-phinf.pstatic.net%2F20250313_89%2F1741833348707BqPkq_JPEG%2F269_36616430_image_url_1741833348684.jpg"><br>
	<p>리멤버 : 그 시절, 기억을 걷다. - 부산</p><br>
	<div class="btn-group">
			<input type="button" value="상세정보" onclick="location.href='remember'">
			<input type="button" value="예매하기" onclick="location.href='reserve?title=기억을 걷다'">
		</div>
	</div>
	<div>
	<h3>공연 종료 작품</h3>
	<img src="https://search.pstatic.net/common?type=f&size=224x338&quality=100&direct=true&src=https%3A%2F%2Fcsearch-phinf.pstatic.net%2F20250307_26%2F1741318943213NDcAo_JPEG%2F269_36590883_image_url_1741318943206.jpg"><br>
	<p>OUR TOWN-아주 보통의 하루 - 부산</p><br>
	<div class="btn-group">
			
			<input type="button" value="후기작성" onclick="location.href='review'">
	</div>
	</div>
</div>
</body>
</html>