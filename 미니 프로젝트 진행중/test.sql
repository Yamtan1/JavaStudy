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

select * from movie;

CREATE TABLE movie_detail (
    movie_id NUMBER PRIMARY KEY,
    director VARCHAR2(100),
    actors VARCHAR2(500), -- 쉼표로 구분된 문자열 가능
    synopsis CLOB, -- 줄거리
    trailer_url VARCHAR2(200), -- 예고편 영상
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);
select * from movie_detail;
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
외톨이 소녀 ‘릴로’와 금쪽이 ‘스티치’의 버라이어티한 모험을 확인하라!', '/previews/missionImpossible.mp4');

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

INSERT INTO review VALUES (review_seq.nextval, 'gndn1234', 1, 5.0, '정말재밋어요', SYSDATE);
INSERT INTO review VALUES (review_seq.nextval, 'gndn1234', 3, 4.0, '정말재밋어요', SYSDATE);
INSERT INTO review VALUES (review_seq.nextval, 'gndn1234', 4, 3.0, '정말재밋어요', SYSDATE);
INSERT INTO review VALUES (review_seq.nextval, 'gndn1234', 2, 2.0, '정말재밋어요', SYSDATE);
INSERT INTO review VALUES (review_seq.nextval, 'gndn1234', 1, 4.9, '정말재밋어요', SYSDATE);
select * FROM review;

SELECT movie_id
	    FROM review
	    GROUP BY movie_id
	    ORDER BY AVG(rating) DESC
	    FETCH FIRST 4 ROWS ONLY;
        
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

commit;