<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	#container {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
	}
	
	#container > div {
	    width: 300px;
	    height: auto; /* 고정 높이 지정 */
	    border: 1px solid #ccc;
	    padding: 10px;
	    text-align: center;
	    box-sizing: border-box;
	
	    display: flex;
	    flex-direction: column;
	    justify-content: space-between; /* 버튼을 맨 아래로 밀기 */
	}
	
	#container img {
	    width: 100%;
	    height: 100%;
	    object-fit: cover;
	}
	
	.btn-group {
	    margin-top: 10px;
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
			<input type="button" value="상세정보">
			<input type="button" value="예매하기" onclick="location.href='reserve?title=테일러 메이드'">
	</div>
	</div>
	<div>
	<h3>공연 예정 작품</h3>
	<img src="https://search.pstatic.net/common?type=f&size=224x338&quality=100&direct=true&src=https%3A%2F%2Fcsearch-phinf.pstatic.net%2F20250313_89%2F1741833348707BqPkq_JPEG%2F269_36616430_image_url_1741833348684.jpg"><br>
	<p>리멤버 : 그 시절, 기억을 걷다. - 부산</p><br>
	<div class="btn-group">
			<input type="button" value="상세정보">
			<input type="button" value="예매하기" onclick="location.href='reserve?title=기억을 걷다'">
		</div>
	</div>
	<div>
	<h3>공연 종료 작품</h3>
	<img src="https://search.pstatic.net/common?type=f&size=224x338&quality=100&direct=true&src=https%3A%2F%2Fcsearch-phinf.pstatic.net%2F20250307_26%2F1741318943213NDcAo_JPEG%2F269_36590883_image_url_1741318943206.jpg"><br>
	<p>OUR TOWN-아주 보통의 하루 - 부산</p><br>
	<div class="btn-group">
			<input type="button" value="상세정보">
			<input type="button" value="후기작성">
	</div>
	</div>
</div>
</body>
</html>