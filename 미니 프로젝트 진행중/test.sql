CREATE TABLE googv_user (
    id VARCHAR2(20) PRIMARY KEY,
    pw VARCHAR2(255),
    name VARCHAR2(30),
    phone VARCHAR2(20),
    email VARCHAR2(100),
    grade VARCHAR2(20),  -- [WELCOME,GREEN,VIP]
    free_spin NUMBER DEFAULT 0, -- 응모권
    reg_date DATE DEFAULT SYSDATE,
    point NUMBER DEFAULT 0
);
CREATE TABLE movie (
    movie_id NUMBER PRIMARY KEY,
    title VARCHAR2(100), -- 제목
    genre VARCHAR2(50), -- 장르
    rating VARCHAR2(100), -- 관람 등급
    start_date DATE, -- 상영 시작일
    end_date DATE, -- 상영 종료일
    duration NUMBER, -- 러닝 타임
    poster_url VARCHAR2(200)
);

CREATE SEQUENCE movie_seq;
INSERT INTO movie VALUES (movie_seq.nextval, '미션 임파서블:파이널 레코닝', '액션/미국', '15세이상관람가', '2025-05-17', '2025-06-18', '169', '/images/missionImpossible.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '릴로 & 스티치', '애니메이션/미국', '전체관람가', '2025-05-21', '2025-06-28', '108', '/images/LiloStitch.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '야당', '범죄, 액션 / 한국', '청소년관람불가', '2025.04.16', '2025-06-20', '123', '/images/yadang.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '플립', '드라마, 멜로/로맨스 / 미국', '12세이상관람가', '2025.05.21', '2025-07-20', '90', '/images/flip.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '파과', '액션, 드라마, 미스터리 / 한국', '15세이상관람가', '2025.04.30 ', '2025-06-29', '122', '/images/pagwa.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '씨너스: 죄인들', '액션 / 미국', '청소년관람불가', '2025.05.28 ', '2025-07-27', '137', '/images/Cinus.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '브릭레이어', '액션, 스릴러 / 기타', '15세이상관람가', '2025.05.28 ', '2025-07-27', '110', '/images/brick.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '페니키안 스킴', '드라마, 코미디 / 미국', '15세이상관람가', '2025.05.28 ', '2025-07-27', '101', '/images/skim.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '해피엔드', '드라마 / 일본', '15세이상관람가', '2025.04.30 ', '2025-06-29', '113', '/images/happyend.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '콘클라베', '드라마, 스릴러 / 영국, 미국', '12세이상관람가', '2025.03.05', '2025-06-01', '120', '/images/conclave.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '플로우', '애니메이션 / 기타', '전체관람가', '2025.03.19', '2025-06-18', '85', '/images/flow.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '달팽이의 회고록', '애니메이션 / 호주', '15세이상관람가', '2025.04.30', '2025-06-29', '95', '/images/snail.jpg');
INSERT INTO movie VALUES (movie_seq.nextval, '보이 인 더 풀', '드라마, 멜로/로맨스 / 한국', '12세이상관람가', '2025.05.14', '2025-07-13', '89', '/images/boy.jpg');

INSERT INTO movie_detail VALUES (1, '크리스토머 맥쿼리', '톰 크루즈, 헤일리 앳웰, 빙 라메스, 사이먼 페그, 바네사 커비, 에사이 모랄레스, 폼 클레멘티에프', '디지털상의 모든 정보를 통제할 수 있는 사상 초유의 무기로 인해
전 세계 국가와 조직의 기능이 마비되고, 인류 전체가 위협받는 절체절명의 위기가 찾아온다.
이를 막을 수 있는 건 오직 존재 자체가 기밀인 ‘에단 헌트’와
그가 소속된 IMF(Impossible Mission Force)뿐이다.

무기를 무력화하는 데 반드시 필요한 키를 손에 쥔 ‘에단 헌트’.
오랜 동료 ‘루터’와 ‘벤지’, 그리고 새로운 팀원이 된 ‘그레이스’, ‘파리’, ‘드가’와 함께
지금껏 경험했던 그 어떤 상대보다도 강력한 적에 맞서
모두의 운명을 건 불가능한 미션에 뛰어든다!', '/previews/missionImpossible.mp4');

INSERT INTO movie_detail VALUES (2, '딘 플레이셔 캠프', '크리스 샌더스, 마이아 케알로하, 시드니 엘리자베스 아구동', '2002년 디즈니 대표 클래식 애니메이션 명작
2025년 웃음과 감동 가득한 귀염 폭발 어드벤처로 돌아오다!

보송보송한 파란 솜털, 호기심 가득한 큰 눈, 장난기 가득한 웃음을 가졌지만..!
가장 위험한 실험체 취급을 받던 ‘스티치’는
우주에서 도망쳐 지구의 하와이 섬에 불시착하게 된다.

단짝 친구를 원하던 외톨이 소녀 ‘릴로’는
별똥별과 함께 나타난 귀여운 파란색 강아지(?) ‘스티치’와
소중한 친구이자, 하나의 가족이 되어가며 외로웠던 일상이 유쾌하게 변하기 시작한다.

그러던 어느 날, ‘스티치’를 잡아 우주로 되돌아가려는
정체불명의 요원들이 등장하고
‘릴로’와 ‘스티치’는 예상치 못한 상황을 마주하게 되는데…!

완벽하진 않지만 가장 사랑스러운 가족
외톨이 소녀 ‘릴로’와 금쪽이 ‘스티치’의 버라이어티한 모험을 확인하라!', '/previews/LiloStitch.mp4');

INSERT INTO movie_detail VALUES (4, '롭 라이너', ' 매들린 캐롤, 캘런 맥오리피', '단 한 순간, 세상이 뒤집혔다!
옆집에 이사 온 브라이스에게 첫눈에 반해버린 7살 소녀 줄리.
브라이스를 향한 줄리의 마음은 언제나 직진이지만, 브라이스는 줄리가 부담스럽기만 하다.
6년이 지나도 브라이스를 향한 마음이 꺾이지 않는 줄리는 브라이스에게 마음이 담긴 작고 소중한 선물을 매일매일 주기로 한다.
하지만 브라이스는 줄리의 마음이 담긴 선물을 쓰레기통에 버리다 들키고, 그 날 이후 줄리는 브라이스를 피하기 시작하는데…
어째서인지 그때부터 브라이스는 줄리가 신경 쓰이기 시작한다?!', '/previews/flip.mp4');

INSERT INTO movie_detail VALUES (3, '황병국', ' 강하늘, 유해진, 박해준, 류경수, 채원빈', '대한민국 마약 수사의 뒷거래
모든 것은 야당으로부터 시작된다!

누명을 쓰고 교도소에 수감된 이강수(강하늘)는
검사 구관희(유해진)로부터 감형을 조건으로 야당을 제안받는다.
강수는 관희의 야당이 돼 마약 수사를 뒤흔들기 시작하고,
출세에 대한 야심이 가득한 관희는 굵직한 실적을 올려 탄탄대로의 승진을 거듭한다.

한편, 마약수사대 형사 오상재(박해준)는 수사 과정에서 강수의 야당질로 번번이 허탕을 치고,
끈질긴 집념으로 강수와 관희의 관계를 파고든다.

마약판을 설계하는 브로커 강수, 더 높은 곳에 오르려는 관희, 마약 범죄 소탕에 모든 것을 건 상재.
세 사람은 각자 다른 이해관계로 얽히기 시작하는데…', '/previews/yadang.mp4');

INSERT INTO movie_detail VALUES (5, '민규동', '이혜영, 김성철, 연우진, 김무열, 신시아', '지킬 게 생긴 킬러 VS 잃을 게 없는 킬러

40여 년간 감정 없이 바퀴벌레 같은 인간들을 방역해온 60대 킬러 ‘조각’(이혜영).
‘대모님’이라 불리며 살아있는 전설로 추앙받지만
오랜 시간 몸담은 회사 ‘신성방역’에서도 점차 한물간 취급을 받는다.

한편, 평생 ‘조각’을 쫓은 젊고 혈기 왕성한 킬러 ‘투우’(김성철)는
‘신성방역’의 새로운 일원이 되고 ‘조각’에게서 시선을 떼지 않는다.

스승 ‘류’(김무열)와 지켜야 할 건 만들지 말자고 약속했던 ‘조각’은
예기치 않게 상처를 입은 그날 밤,
자신을 치료해 준 수의사 ‘강선생’(연우진)과 그의 딸에게 남다른 감정을 느낀다.

‘투우’는 그런 낯선 ‘조각’의 모습에 분노가 폭발하는데…

삶의 끝자락에서, 가장 강렬한 대결이 시작된다!', '/previews/pagwa.mp4');

INSERT INTO movie_detail VALUES (6, '라이언 쿠글러', ' 마이클 B. 조던, 헤일리 스타인펠드', '1932년, 시카고 갱단의 생활을 정리하고 고향 미시시피로 돌아온
쌍둥이 형제 ‘스모크’와 ‘스택’(마이클 B. 조던)은 큰돈을 벌기 위해
술집 ‘주크 조인트’를 운영하기로 한다.

화려한 오프닝 파티가 열리는 밤,
천부적인 재능을 지닌 ‘새미’(마일스 케이턴)의 노래로 파티의 열기는 점점 뜨거워지고
초대하지 않은 불청객 일행이 찾아오는데…

그날 밤, 우리는 악을 깨웠다!', '/previews/Cinus.mp4');

INSERT INTO movie_detail VALUES (7, '레니 할린', '아론 에크하트, 니나 도브레브', 'CIA의 최고의 요원들이 연이어 사라지는 사건이 발생하고, 브릭레이어라는
별명의 전설적 존재로 불리우던 전직 CIA 요원 ‘스티브 베일’을 다시 불러들인다.

베일은 현직 CIA 요원 ‘케이트 배넌’과 파트너가 되어 사라진 요원들을 추적하지만
예상치 못한 반전과 갈등에 휘말리게 되는데..

과연, 베일은 자신의 과거와 싸우며 적들을 제압하고,
CIA의 존폐를 위협하는 숨겨진 적을 무너뜨릴 수 있을까?

운명을 걸고 펼쳐지는 치열한 추적과 반전의 연속
모든 것을 걸고 싸워야 하는 순간이 다가온다.', '/previews/brick.mp4');

INSERT INTO movie_detail VALUES (8, '웨스 앤더슨', '베니치오 델 토로, 미아 트리플턴, 마이클 세라, 리즈 아메드, 톰 행크스, 브라이언 크랜스톤, 마티유 아말릭',
'“모든 자료는 저 신발 상자에 들어있다.
내가 30년간 공을 들인 일생일대의 프로젝트지.”

6번의 추락 사고와 숱한 암살 위협으로부터 살아 돌아온 거물 사업가 자자 코다.

계속되는 경쟁자들의 방해에 위협을 느낀 그는 일생일대 숙원 사업인 ‘페니키안 스킴’을 완수하기 위해 수련수녀인 외동딸 리즐을 상속자로 지정하고 집으로 불러들인다.

그러나, 갑작스러운 적들의 방해로 인해 자자 코다의 사업이 무너질 위기에 처하자, 자자는 딸 리즐과 가정교사 비욘을 데리고 주요 동업자들을 설득하기 위해 페니키아로 떠나는데…', '/previews/skim.mp4');

INSERT INTO movie_detail VALUES (9, '소라 네오', '쿠니하라 하야토, 히다카 유키토, 하야시 유타, 시나 펭, 아라지, 이노리 키라라, 나카지마 아유무',
'점멸등이 일렁이는 근미래의 도쿄.

음악에 빠진 고등학생 ‘유타’와 ‘코우’는
친구들과 함께 자유로운 나날을 보낸다

동아리방을 찾아 늦은 밤 학교에 잠입한 그들은
교장 ‘나가이’의 고급 차량에 발칙한 장난을 치고,
분노한 학교는 AI 감시 체제를 도입한다

그날 이후 그들을 둘러싼
모든 것이 조금씩 달라지기 시작하는데…', '/previews/happyend.mp4');

INSERT INTO movie_detail VALUES (10, '에드워드 버거', '랄프 파인즈, 스탠리 투치, 존 리스고, 이사벨라 로셀리니',
'교황의 예기치 못한 죽음 이후 새로운 교황을 선출하는 ‘콘클라베’가 시작되고,
로렌스(랄프 파인즈)는 단장으로서 선거를 총괄하게 된다.
한편 당선에 유력했던 후보들이 스캔들에 휘말리면서
교활한 음모와 탐욕이 수면 위로 드러나는데…', '/previews/conclave.mp4');

INSERT INTO movie_detail VALUES (11, '긴츠 질발로디스', NULL,
'파도가 끝나는 곳,
고양이의 모험이 시작된다!

인간이 살았던 흔적만이 남아있는 세상,
홀로 집을 지키던 고양이는 갑작스러운 대홍수로
평화롭던 일상과 아늑했던 터전을 잃고 만다.

때마침 다가온 낡은 배에 올라탄 고양이는
그 안에서 골든 리트리버, 카피바라, 여우원숭이, 뱀잡이수리를 만나고
서로의 차이점을 극복하고 팀을 이뤄 험난한 파도를 헤쳐나간다.', '/previews/flow.mp4');

INSERT INTO movie_detail VALUES (12, '아담 엘리어트', '새라 스누크, 에릭 바나, 재키 위버, 코디 스밋 맥피, 도미니크 피뇽',
'"이제 너도 그 껍질에서 나올 차례야."
"우린 앞을 보고 살아야 해, 꼭 기억해. 과거에 머물러 있지마"

그레이스는 자신의 달팽이, 실비아에게 살아온 이야기를 시작한다.
잦은 병치레, 수면무호흡증으로 언제 위험해질지 모르는 알코올 중독자 아빠,
또래 친구들의 괴롭힘…

씁쓸한 유년 시절 유일한 빛이자 영웅이 되어준 건 쌍둥이 길버트이다.
하지만 서로 다른 지역으로 입양돼 헤어지게 되며 서로에 대한 그리움으로 하루하루를 살아나간다.
계속되는 잔잔하고도 외로운 일상 속, 우연히 ‘핑키’라는 괴짜 할머니를 만나 우정을 쌓게 되고
그레이스는 다시금 인생의 희망을 찾아가기 시작하는데…', '/previews/snail.mp4');

INSERT INTO movie_detail VALUES (13, '류연수', '효우, 이민재, 이예원, 양희원',
'『여름, 2007』 “비밀로 할 수 있어?”
수영을 좋아하는 소녀 ‘석영’은 물갈퀴를 가진 특별한 소년 ‘우주’를 만난다.
‘우주’의 물갈퀴는 ‘석영’과 ‘우주’ 둘만의 비밀이 되고, 평생 같이 수영을 하기로 약속한다.
하지만 ‘우주’는 남들과 다른 특별함으로 수영에 두각을 나타내며 헤어지게 되는데...

『여름, 2013』 “너만 내 얘길 들어줄 수 있어”
특별했던 ‘우주’의 세계는 희미해지는 물갈퀴처럼 점점 평범해지고,
‘우주’는 자신의 비밀을 알고 있는 ‘석영’을 찾아가게 되는데...

예민한 감정 사이를 헤엄치는
소녀와 소년의 비밀과 성장을 담은 청춘 연대기가 시작된다!', '/previews/boy.mp4');

select * from movie;

CREATE TABLE movie_detail (
    movie_id NUMBER PRIMARY KEY,
    director VARCHAR2(100),
    actors VARCHAR2(500), -- 쉼표로 구분된 문자열 가능
    synopsis CLOB, -- 줄거리
    trailer_url VARCHAR2(200), -- 예고편 영상
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

CREATE TABLE theater (
    theater_id NUMBER PRIMARY KEY,      -- 상영관 고유 ID
    name VARCHAR2(50),                  -- 상영관 이름 (예: 1관, 2관)
    total_seats NUMBER                 -- 좌석 수
);

CREATE TABLE seat (
    seat_id NUMBER PRIMARY KEY,
    theater_id NUMBER,                  -- 어느 상영관 소속 좌석인지
    row_label VARCHAR2(5),              -- 예: A, B, C
    col_number NUMBER,                  -- 열 번호: 1, 2, 3...
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);
INSERT INTO theater (theater_id, name, total_seats)
VALUES (1, '1관', 32);
INSERT INTO theater (theater_id, name, total_seats)
VALUES (2, '2관', 32);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (1, 1, 'A', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (2, 1, 'A', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (3, 1, 'A', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (4, 1, 'A', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (5, 1, 'A', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (6, 1, 'A', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (7, 1, 'A', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (8, 1, 'A', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (9, 1, 'B', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (10, 1, 'B', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (11, 1, 'B', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (12, 1, 'B', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (13, 1, 'B', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (14, 1, 'B', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (15, 1, 'B', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (16, 1, 'B', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (17, 1, 'C', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (18, 1, 'C', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (19, 1, 'C', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (20, 1, 'C', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (21, 1, 'C', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (22, 1, 'C', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (23, 1, 'C', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (24, 1, 'C', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (25, 1, 'D', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (26, 1, 'D', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (27, 1, 'D', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (28, 1, 'D', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (29, 1, 'D', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (30, 1, 'D', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (31, 1, 'D', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (32, 1, 'D', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (33, 2, 'A', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (34, 2, 'A', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (35, 2, 'A', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (36, 2, 'A', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (37, 2, 'A', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (38, 2, 'A', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (39, 2, 'A', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (40, 2, 'A', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (41, 2, 'B', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (42, 2, 'B', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (43, 2, 'B', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (44, 2, 'B', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (45, 2, 'B', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (46, 2, 'B', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (47, 2, 'B', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (48, 2, 'B', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (49, 2, 'C', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (50, 2, 'C', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (51, 2, 'C', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (52, 2, 'C', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (53, 2, 'C', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (54, 2, 'C', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (55, 2, 'C', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (56, 2, 'C', 8);

INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (57, 2, 'D', 1);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (58, 2, 'D', 2);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (59, 2, 'D', 3);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (60, 2, 'D', 4);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (61, 2, 'D', 5);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (62, 2, 'D', 6);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (63, 2, 'D', 7);
INSERT INTO seat (seat_id, theater_id, row_label, col_number) VALUES (64, 2, 'D', 8);

CREATE TABLE schedule (
    schedule_id NUMBER PRIMARY KEY,
    movie_id NUMBER,
    theater_id NUMBER,                  -- 어떤 상영관에서 상영되는지
    show_datetime DATE,
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);
select * from schedule;
INSERT INTO schedule VALUES (schedule_seq.nextval, 1, 1, SYSDATE - 1);
INSERT INTO schedule VALUES (schedule_seq.nextval, 1, 1, '2025-05-29');
INSERT INTO schedule VALUES (schedule_seq.nextval, 2, 2, '2025-05-29');
create sequence schedule_seq;
commit;
CREATE TABLE reserved_seat (
    schedule_id NUMBER,
    seat_id NUMBER,
    is_reserved CHAR(1) DEFAULT 'N',
    PRIMARY KEY (schedule_id, seat_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(schedule_id),
    FOREIGN KEY (seat_id) REFERENCES seat(seat_id)
);

CREATE TABLE reservation (
    reserve_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(20),
    schedule_id NUMBER,
    seat_id NUMBER,
    reserve_date DATE DEFAULT SYSDATE,
    status VARCHAR2(10), -- 완료 / 취소
    FOREIGN KEY (user_id) REFERENCES googv_user(id),
    FOREIGN KEY (schedule_id) REFERENCES schedule(schedule_id),
    FOREIGN KEY (seat_id) REFERENCES seat(seat_id)
);
INSERT INTO reservation VALUES (reserve_seq.nextval, 'gndndk12345', 4, 5, sysdate - 2, '완료');
create sequence reserve_seq;

CREATE TABLE payment (
    payment_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(20),            -- 결제한 사용자
    payment_type VARCHAR2(10),       -- '예매', '대관', '광고'
    target_id NUMBER,                -- 해당 결제 대상의 ID (reservation_id or rental_id or ad_id)
    amount NUMBER,
    pay_date DATE DEFAULT SYSDATE,
    FOREIGN KEY (user_id) REFERENCES googv_user(id)
);

create sequence payment_seq;

CREATE TABLE qna (
    qna_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(20),
    title VARCHAR2(100),
    content CLOB,
    qna_date DATE DEFAULT SYSDATE,
    
    status VARCHAR2(10) DEFAULT '대기', -- '대기' 또는 '완료'
    answer CLOB DEFAULT NULL,           -- 관리자의 답변 (없으면 NULL)
    
    FOREIGN KEY (user_id) REFERENCES googv_user(id)
);

CREATE TABLE review (
    review_id NUMBER PRIMARY KEY,       -- 각 리뷰를 식별하는 ID (리뷰 번호)
    user_id VARCHAR2(20),               -- 리뷰를 작성한 회원 ID (user 테이블 참조)
    movie_id NUMBER,                    -- 리뷰 대상 영화 ID (movie 테이블 참조)
    rating NUMBER(2,1),                 -- 평점 (예: 3.5, 4.0) → 소수점 1자리까지 저장
    content VARCHAR2(1000),             -- 리뷰 텍스트 (최대 1000자)
    review_date DATE DEFAULT SYSDATE,   -- 리뷰 작성일 (기본값: 현재 시간)
    FOREIGN KEY (user_id) REFERENCES googv_user(id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

CREATE SEQUENCE review_seq;

CREATE TABLE rental (
    rental_id NUMBER PRIMARY KEY,         -- 대관 신청 고유번호
    user_id VARCHAR2(20),                 -- 신청한 사용자 ID
    theater_id NUMBER,                    -- 대관하려는 상영관 ID
    desired_datetime DATE,                -- 대관을 원하는 날짜 및 시간
    purpose VARCHAR2(100),                -- 대관 목적 (ex: 시사회, 동호회 상영 등)
    status VARCHAR2(20) DEFAULT '대기',   -- 신청 상태 ('대기', '승인', '반려' 등)
    request_date DATE DEFAULT SYSDATE,    -- 신청한 날짜
    FOREIGN KEY (user_id) REFERENCES googv_user(id),
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);

create sequence rental_seq;

CREATE TABLE ad ( -- 광고신청
    ad_id NUMBER PRIMARY KEY,
	  user_id VARCHAR2(20), 
    title VARCHAR2(100),
    image_url VARCHAR2(200),
    link_url VARCHAR2(200),
    status VARCHAR2(20) DEFAULT '대기',   -- 신청 상태 ('대기', '승인', '반려' 등),
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (user_id) REFERENCES googv_user(id)
);
select * from ad;
CREATE SEQUENCE ad_seq; -- ad_id 시퀸스로 활용

CREATE TABLE visit_log (
    log_id NUMBER PRIMARY KEY,              -- 각 방문 로그를 식별하는 고유 ID
    ip_address VARCHAR2(45),                -- 방문자의 IP 주소 (IPv6도 대응 가능)
    visit_time DATE DEFAULT SYSDATE         -- 방문 시각 (기본값: 현재 시간)
);

CREATE TABLE coupon (
    coupon_id NUMBER PRIMARY KEY,             -- 쿠폰 고유 ID
    name VARCHAR2(50),                        -- 쿠폰 이름 (예: 20% 할인, 영화 이용권)
    description VARCHAR2(200),                -- 쿠폰 설명 (예: "모든 영화에 사용 가능")
    discount_type VARCHAR2(20),               -- 할인 유형: '퍼센트', '정액', '무료이용'
    discount_value NUMBER,                    -- 할인 수치 (예: 20 → 20%, 5000 → 5000원 할인)
    valid_days NUMBER,                        -- 발급일로부터 유효한 일 수 (예: 7일)
    use_limit NUMBER DEFAULT 1                -- 사용 가능 횟수 (기본 1회)
);

-- 1. 20% 할인 쿠폰
INSERT INTO coupon (coupon_id, name, description, discount_type, discount_value, valid_days)
VALUES (1, '20% 할인 쿠폰', '모든 영화에 사용 가능', '퍼센트', 20, 2);

-- 2. 5,000원 할인 쿠폰
INSERT INTO coupon (coupon_id, name, description, discount_type, discount_value, valid_days)
VALUES (2, '5,000원 할인 쿠폰', '5천원 할인 쿠폰', '할인', 5000, 1);

-- 3. 영화 1회 무료 이용권
INSERT INTO coupon (coupon_id, name, description, discount_type, discount_value, valid_days)
VALUES (3, '무료 이용권', '모든 영화 1인 무료 이용 가능', '이용권', 15000, 2);

CREATE TABLE user_coupon (
    user_coupon_id NUMBER PRIMARY KEY,        -- 사용자 쿠폰 고유 ID
    user_id VARCHAR2(20),                     -- 쿠폰을 받은 회원 ID
    coupon_id NUMBER,                         -- 어떤 쿠폰인지 (coupon 테이블 참조)
    issued_date DATE DEFAULT SYSDATE,         -- 쿠폰 발급일
    expiry_date DATE,                         -- 만료일 (issued_date + valid_days 기준으로 계산)
    is_used CHAR(1) DEFAULT 'N',              -- 쿠폰 사용 여부 ('N': 미사용, 'Y': 사용 완료)
    FOREIGN KEY (user_id) REFERENCES googv_user(id),         -- user 테이블 참조
    FOREIGN KEY (coupon_id) REFERENCES coupon(coupon_id)    -- coupon 테이블 참조
);
CREATE SEQUENCE user_coupon_seq;
CREATE TABLE faq (
    faq_id NUMBER PRIMARY KEY,
    title VARCHAR2(300),
    content CLOB,
    reg_date DATE DEFAULT SYSDATE,
    view_count NUMBER DEFAULT 0
);

commit;
select * FROM reservation;
select * FROM user_coupon;
update googv_user set free_spin = 100 WHERE id='gndndk12345';
UPDATE reservation
SET reserve_date = SYSDATE - 1
WHERE reserve_id = 1;
