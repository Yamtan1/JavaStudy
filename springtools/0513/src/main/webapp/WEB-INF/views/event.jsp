<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>이벤트 페이지</h1>
<hr>
<%@ include file="header2.jsp" %>
<table border="1">
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>이벤트 기간</th><th>비고</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td><td>오픈기념 무료 예매권 추첨 이벤트</td><td>05.13~05.20</td><td><input type="button" value="응모하기" onclick="joinEvent()"></td>
		</tr>
	</tbody>
</table>

<script>
	
	function joinEvent(){
		const grade = "${sessionScope.grade}"
			if (grade === "관리자" || grade === "") {
		        alert("회원만 참여할 수 있습니다.");
		        return;  
		    }
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const result = xhr.responseText;
			if(result === "true"){
				alert("이벤트에 참여되었습니다.");
			}
			else{
				alert("응모횟수를 모두 사용하셨습니다.");
			}
		}
		xhr.open('GET', '/joinEvent');
		xhr.send();
	}
</script>
</body>
</html>