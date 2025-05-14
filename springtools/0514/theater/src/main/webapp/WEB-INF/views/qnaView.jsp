<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  font-family: 'Segoe UI', sans-serif;
  background-color: #fcfcfc;
  color: #333;
  padding: 30px;
}

h1 {
  color: #444;
}

input[type="text"] {
  width: 100%;
  padding: 8px;
  margin: 6px 0;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
  background-color: #f9f9f9;
}

.answer-box {
  background-color: #e6f7ff;
  padding: 15px;
  margin-top: 20px;
  border-left: 4px solid #3399ff;
  border-radius: 6px;
}

input[type="button"] {
  background-color: #0077cc;
  color: white;
  padding: 8px 14px;
  border: none;
  border-radius: 6px;
  margin-top: 20px;
  cursor: pointer;
}

input[type="button"]:hover {
  background-color: #005fa3;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>문의사항 상세보기</h1>
<hr>
<%@ include file="header2.jsp" %>

제목 : <input type="text" name="qtitle" id="qtitle" value="${qna.qtitle }" readonly><br>
문의내용 : <input type="text" name="qcontent" id="qcontent" value="${qna.qcontent }" readonly><br>
작성자 : <input type="text" name="id" id="id" value="${qna.id }" readonly><br>
작성일 : <input type="text" name="qdate" id="qdate" value="${qna.qdate }" readonly><br>
<c:if test="${not empty answer}">
    <div class="answer-box">
        <p>답변 내용: ${qna.answer}</p>
    </div>
</c:if>
<input type="button" value="답변달기(관리자만 가능)" onclick="answer()">

<script>
	
	function answer(){
		const id = document.getElementById('id').value;
		const qtitle = document.getElementById('qtitle').value;
		const qcontent = document.getElementById('qcontent').value;
		const qdate = document.getElementById('qdate').value;
		
		const xhr = new XMLHttpRequest();
		xhr.onload=function(){
			   if (xhr.status === 200) {
		            // 응답이 성공적으로 왔을 때
		            document.open();               // 현재 문서 초기화
		            document.write(xhr.response);  // 응답 내용을 HTML로 렌더링
		            document.close();
		        } else {
		            alert("요청 실패: " + xhr.status);
		        }
		}
		xhr.open('POST', '/qnaAnswer')
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("id="+id+ "&qtitle="+qtitle+"&qcontent="+qcontent+"&qdate="+qdate);
	}
</script>

</body>
</html>