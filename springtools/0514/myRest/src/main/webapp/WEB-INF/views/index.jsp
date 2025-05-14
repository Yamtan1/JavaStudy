<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<h1>Index</h1>
<hr>
<button onclick="run()">실행</button>
<div id="demo">----------</div>
<button onclick="run2()">실행(POST)</button>
<div id="demo2">----------</div>
<button onclick="run3()">실행(GET방식 2)</button>
<div id="demo3">----------</div>
<button onclick="run4()">실행(POST방식 2)</button>
<div id="demo3">----------</div>


<script>
function run4(){
	const formData = new FormData();
	form.Data.append('id', 'ddd');
	form.Data.append('name', 'Dennis');
	
	axios.post('/api/user', formData,{
		header : {
			'Content-Type' : 'multipart/form-data'
		}
	})
	.then(response => {
		cosole.log('POST(Form) 성공 : ' + response.data);
	})
	.catch(error => {
		console.log('POST(form) 실패 : ' + error);
	})
}
function run3(){
	 //GET 방식 요청
	 axios.get('/api/user', {
		 params : {
			 id : 'hong',
			 name :'Hong gil dong'
		 }
	 })
	 .then(response => {
		 console.log(response.data);
		document.getElementById('demo3').innerHTML = response.data.id + ", " + response.data.name; 
	 })
	 .catch(error =>{
		 document.getElementById('demo3').innerHTML = error;
	 });
}
function run2(){
	 //POST 방식 요청
	 axios.get('/api/user', {
		 name : 'James Dean',
		 id : 'JD'
	 })
	 .then(response => {
		 console.log(response.data);
		document.getElementById('demo2').innerHTML = response.data.id + ", " + response.data.name; 
	 })
	 .catch(error =>{
		 document.getElementById('demo2').innerHTML = error;
	 });
}
	function run(){
		 //GET 방식 요청
		 axios.get('/api/user/1')
		 .then(response => {
			 console.log(response.data);
			document.getElementById('demo').innerHTML = response.data.id + ", " + response.data.name; 
		 })
		 .catch(error =>{
			 document.getElementById('demo').innerHTML = error;
		 });
	}	

</script>
</body>
</html>