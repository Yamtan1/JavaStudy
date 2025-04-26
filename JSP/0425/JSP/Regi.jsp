<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    // 이 함수는 폼이 제출된 후 알림창을 띄웁니다.
    function showAlert() {
        alert("주문이 완료되었습니다.");
    }
</script>
</head>
<body>
<jsp:include page="index.jsp" />
<h1>주문등록</h1>
<hr>
<form action="regi" method="GET" onsubmit="showAlert()">
주문번호 : <input type="text" name="orderno" required><br>
주문 점포 : <select name="shopno" required>
	<option value="">점포선택</option>
	<option value="S001">S001(AA할인점)</option> 
	<option value="S002">S002(BB할인점)</option>
	<option value="S003">S003(CC할인점)</option>
	<option value="S004">S004(DD할인점)</option>
</select><br>
주문일자 : <input type="text" name="orderdate" required><br>
제품코드 : <select name="pcode" required>
	<option value="">코드선택</option>
	<option value="AA01">AA01(삼각김밥)</option> 
	<option value="AA02">AA02(도시락)</option>
	<option value="AA03">AA03(봉지만두)</option>
	<option value="AA04">AA04(컵라면)</option>
	<option value="AA05">AA05(아메리카노)</option>
	<option value="AA06">AA06(콜라)</option>
</select><br>
주문수량 : <input type="text" name="amount" required><br>
<input type="submit" value="주문등록"> 
</form>
<form action="index.jsp">
<input type="submit" value="다시쓰기">
</form>
</body>
</html>