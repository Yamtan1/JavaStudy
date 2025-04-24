CREATE TABLE member_tbl_02(
custno NUMBER(6) PRIMARY KEY,
custname VARCHAR2(20),
phone VARCHAR2(13),
address VARCHAR2(60),
joindate DATE,
grade CHAR(1),
city CHAR(2)
);

CREATE TABLE money_tbl_02(
custno NUMBER(6), 
saleno NUMBER(8) PRIMARY KEY,
pcost NUMBER(8),
amount NUMBER(4),
price NUMBER(8),
pcode VARCHAR2(4),
sdate DATE,
constraint fk_member_tbl_02 FOREIGN KEY (custno)
REFERENCES member_tbl_02(custno)
);

INSERT INTO member_tbl_02 VALUES (10001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '2015-12-02', 'A','01');
INSERT INTO member_tbl_02 VALUES (10002, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '2015-12-06', 'B','01');
INSERT INTO member_tbl_02 VALUES (10003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '2015-10-01', 'B','30');
INSERT INTO member_tbl_02 VALUES (10004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '2015-11-13', 'A','30');
INSERT INTO member_tbl_02 VALUES (10005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '2015-12-25', 'B','60');
INSERT INTO member_tbl_02 VALUES (10006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '2015-12-11', 'C','60');

INSERT INTO money_tbl_02 VALUES (10001, 20160001, 500, 5, 2500, 'A001','20160101');

INSERT INTO money_tbl_02 VALUES (10001, 20160002, 1000, 4, 4000, 'A002','20160101');
INSERT INTO money_tbl_02 VALUES (10001, 20160003, 500, 3, 1500, 'A008','20160101');
INSERT INTO money_tbl_02 VALUES (10002, 20160004, 2000, 1, 2000, 'A004','20160102');
INSERT INTO money_tbl_02 VALUES (10002, 20160005, 500, 1, 500, 'A001','20160103');
INSERT INTO money_tbl_02 VALUES (10003, 20160006, 1500, 2, 3000, 'A003','20160103');
INSERT INTO money_tbl_02 VALUES (10004, 20160007, 500, 2, 1000, 'A001','20160104');
INSERT INTO money_tbl_02 VALUES (10004, 20160008, 300, 1, 300, 'A005','20160104');
INSERT INTO money_tbl_02 VALUES (10004, 20160009, 600, 1, 600, 'A006','20160104');
INSERT INTO money_tbl_02 VALUES (10004, 20160010, 3000, 1, 3000, 'A007','20160106');


CREATE SEQUENCE seq_member -- 여기까지만 실행하면 값이 1씩 증가함
START WITH 10001 -- 처음시작할 숫자
INCREMENT BY 1 -- 증가할 값
--MINVALUE 1 -- 최소값
--MAXVALUE 10 -- 최대값
NOCYCLE --최대값 도달 시 순환여부 // CYCLE or NOCYCLE
NOCACHE; -- 시퀸스번호 캐시할 지 여부

commit;

SELECT m.custno, m.custname, m.grade, m2.price
FROM member_tbl_02 m , money_tbl_02 m2
WHERE m.custno = m2.custno AND price IS NOT NULL;

SELECT m.custno, m.custname, m.grade, SUM(m2.price) AS total_sales
FROM member_tbl_02 m
JOIN money_tbl_02 m2 ON m.custno = m2.custno
WHERE m2.price IS NOT NULL
GROUP BY m.custno, m.custname, m.grade
ORDER BY total_sales DESC;

DELETE FROM member_tbl_02 WHERE custno= 10400;