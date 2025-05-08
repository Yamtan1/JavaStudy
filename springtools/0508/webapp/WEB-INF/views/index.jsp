<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index page</h1>
<hr>
<button onclick="data()">데이터전송</button>
<div id="test1">------</div>

<script>

	const test1 = document.getElementById("test1");
	
	function data(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const obj = JSON.parse(xhr.responseText);
			const items = obj.gyeongnamculturallist.body.items.item;
			// 1. <table> 생성
			const table = document.createElement("table");
			table.border = "1"; //테이블 테두리 픽셀 1픽셀
			table.cellPadding = "5"; // 셀 안의 내용과 테두리 사이 간격(여백)을 5픽셀로 설정
			table.cellSpacing = "0"; // 셀 사이의 간격을 0으로 설정

			// 2. 제목 행 생성
			const headerRow = document.createElement("tr"); //tr태그 생성 <tr></tr>
			const headers = [
				"DOJIJUNG_NO",
				"MYONGCHING",
				"MYONGCHING_HANMUN",
				"CONTENT",
				"MYONJUK",
				"SOYOUJA_NAME",
				"ADMIN_NAME",
				"SIDAE"
			];

			for (let i = 0; i < headers.length; i++) {
				const th = document.createElement("th"); //th태그 생성 <th></th>
				th.textContent = headers[i]; //th태그에 텍스트 넣기
				headerRow.appendChild(th); //tr태그 안에 th태그 넣기
			}
			table.appendChild(headerRow); // 제목행 붙이기

			// 3. 데이터 행들 생성
			for (let i = 0; i < items.length; i++) {
				const item = items[i]; //문화재 개수라고 생각하면 됨
				const row = document.createElement("tr");//데이터 행(가로)만들기

				for (let j = 0; j < headers.length; j++) {
					const key = headers[j];// 문화재의 속성값들 
					const td = document.createElement("td"); //데이터 열(세로) 만들기
					td.textContent = item[key] || ""; //item[key]가 비어 있거나 값이 없으면 빈 문자열("")을 대신 넣겠다는 의미
					row.appendChild(td);
				}
				table.appendChild(row); // 데이터 행 붙이기
			}

			// 4. 출력
			const test1 = document.getElementById("test1");
			test1.innerHTML = ""; // 기존 내용 지우고
			test1.appendChild(table); // 테이블 붙이기
		};
		xhr.open('GET', 'test')
		xhr.send();
	}

</script>
</body>
</html>
