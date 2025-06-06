<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	div#popup{
 		position: absolute; top: 100px; left: 50px; color: yellow;
 		width: 270px; height: 100px; background-color: gray;
 	}
 	div#popup>div{
 		position: relative; background-color: #ffffff; top : 0px;
 		border: 1px solid gray; padding : 10px; color: black;
 	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
	$(function(){
		$('#closeBtn').click(function(){
			$('#popup').hide();
			var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
			console.log("chkVal : " + chkVal);
			if(chkVal == 1){
				$.ajax({
					url : '/popupCookie',
					type: 'get',
					data: {inactiveToday : chkVal}, //보내는데이터
					dataType: 'text', //응답데이터 타입
					success: function(resData){
						console.log(resData);
						if(resData != ''){
							location.reload();
						}
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<%
	String popupMode = "on";
	
	Cookie[] cookies = request.getCookies();	
	if(cookies != null){
		for(Cookie c : cookies){
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			if(cookieName.equals("PopupClose")){
				popupMode = cookieValue;
			}
		}
	}
	%>
	<h1>팝업 메인 페이지</h1>
	<%
	for(int i = 0; i <= 10; i++){
		out.print("현재 팝업창은 " + popupMode + " 상태입니다.<br>");
	}
	if(popupMode.equals("on")){
	%>
	<div id="popup">
		<h2 align="center">공지사항 팝업입니다.</h2>
		<div align="right">
			<form name="popFrm">
				<input type="checkbox" id="inactiveToday" value="1">
				하루동안 열지 않음.
				<input type="button" value="닫기" id="closeBtn">
			</form>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>