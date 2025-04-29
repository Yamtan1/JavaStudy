<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>가위바위보 게임</title>
  <style>
    body { font-family: sans-serif; text-align: center; }
    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 50px;
      margin-top: 20px;
    }
    .player-box {
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .label {
      font-weight: bold;
      font-size: 18px;
      margin-bottom: 5px;
    }
    .choice-box {
      width: 120px;
      height: 120px;
      border: 2px solid #000;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .choice-box img {
      width: 80px;
      height: 80px;
    }
    .result {
      font-size: 24px;
      margin: 20px;
      color: red;
    }
    .score {
      margin-top: 20px;
      font-size: 18px;
    }
    button {
      margin: 5px;
      font-size: 16px;
      padding: 10px 20px;
    }
  </style>
</head>
<body>
<h1>${sessionScope.id} 님, 환영합니다.</h1>
<p>승: <%= session.getAttribute("win") %></p>
<p>패: <%= session.getAttribute("lose") %></p>
<p>무: <%= session.getAttribute("draw") %></p>
<hr>
  <h2>가위바위보 게임</h2>

  <div class="container">
    <div class="player-box">
      <div class="label">COM</div>
      <div class="choice-box"><img id="comImg" src="img/ready.png" alt="COM 선택"></div>
    </div>
    <div style="font-size: 24px;">VS</div>
    <div class="player-box">
      <div class="label">USER</div>
      <div class="choice-box"><img id="userImg" src="img/ready.png" alt="USER 선택"></div>
    </div>
  </div>

  <div class="result" id="resultText">결과: </div>

  <div>
    <button onclick="play('가위')">가위</button>
    <button onclick="play('바위')">바위</button>
    <button onclick="play('보')">보</button>
  </div>

  <div class="score" id="score">0전 0승 0무 0패</div>

  <script>
    let total = 0, win = 0, draw = 0, lose = 0;

    const images = {
      '가위': 'img/scissors.jpg',
      '바위': 'img/rock.jpg',
      '보': 'img/paper.jpg'
    };

    function play(user) {
      const choices = ['가위', '바위', '보'];
      const com = choices[Math.floor(Math.random() * 3)];

      document.getElementById('comImg').src = images[com];
      document.getElementById('userImg').src = images[user];

      let result = '';
      if (user === com) {
        result = 'DRAW!!';
        draw++;
      } else if (
        (user === '가위' && com === '보') ||
        (user === '바위' && com === '가위') ||
        (user === '보' && com === '바위')
      ) {
        result = 'WIN!!';
        win++;
      } else {
        result = 'LOSE!!';
        lose++;
      }

      total++;
      document.getElementById('resultText').textContent = result;
      document.getElementById('score').textContent = `\${total}전 \${win}승 \${draw}무 \${lose}패`;
    }
  </script>

</body>
</html>