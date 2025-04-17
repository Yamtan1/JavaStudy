--view 보안성

CREATE VIEW v_student
AS SELECT * FROM student;

--GRANT CREATE VIEW TO green; 권한 부여
--revoke create view from green; 권한 회수

--enroll subject student 테이블 조인 후

SELECT st.STU_NO, st.STU_NAME, st.STU_DEPT,
su.SUB_NO, su.SUB_NAME, su.SUB_PROP, e.ENR_GRADE
FROM ENROLL e

JOIN STUDENT st ON e.STU_NO = st.STU_NO
JOIN SUBJECT su ON e.SUB_NO = su.SUB_NO;

--view 테이블 만들기
CREATE VIEW v_student_enroll_subject
AS
--테이블조인한거 붙여넣기


SELECT * FROM v_student_enroll_subject WHERE enr_grade >= 60;



SELECT * FROM student1;

DESC student1;

INSERT INTO student1 VALUES (20250417,'홍길동','기계',1,'c','m',190,90);

SAVEPOINT sp1;

INSERT INTO student1 VALUES (20250418,'임꺽정','기계',1,'c','m',160,90);

SAVEPOINT sp2;

INSERT INTO student1 VALUES (20250419,'james','기계',2,'c','m',170,80);

select * from student1;

rollback to sp2; --sp2 임꺽정까지 들어감 sp1홍길동만 
COMMIT;



-----------------------------------------------------------------------------------------------
CREATE TABLE staff(
staff_no NUMBER(6) PRIMARY KEY,
staff_dept VARCHAR2(30),
staff_name VARCHAR2(30),
staff_gender CHAR(1)
);

CREATE TABLE perform(
staff_no NUMBER(6),
p_code NUMBER,
c_code NUMBER,
qty NUMBER(5),
cost NUMBER,
sale_date VARCHAR2(50),
FOREIGN KEY (staff_no)
REFERENCES staff(staff_no),
FOREIGN KEY (p_code)
REFERENCES product(p_code),
FOREIGN KEY (c_code)
REFERENCES customer(c_code)
);

CREATE TABLE p_ledger(
p_code NUMBER,
c_code NUMBER,
p_qty NUMBER,
p_cost NUMBER,
p_date VARCHAR2(50),
FOREIGN KEY (p_code)
REFERENCES product(p_code),
FOREIGN KEY (c_code)
REFERENCES customer(c_code)
);


INSERT INTO customer VALUES (001, '부산제과','김부산','부산시 부산진구 부전동','010-1111-2222');
INSERT INTO customer VALUES (002, '서울우유','박서울','서울시 우유동','010-3333-4444');

INSERT INTO product VALUES (11, '광천김맛꽃게랑','2000','과자류');
INSERT INTO product VALUES (12, '흑당쇼콜라맛동산','3000','과자류');
INSERT INTO product VALUES (21, '부산우유','1500','유제품');
INSERT INTO product VALUES (22, '서울초코우유','1700','유제품');

INSERT INTO staff VALUES (0417001, 'sales','김영업','F');
INSERT INTO staff VALUES (0417002, 'purc','최매입','M');
INSERT INTO staff VALUES (0417003, 'sales','박영입','F');
INSERT INTO staff VALUES (0417004, 'purc','이구매','M');


CREATE SEQUENCE t_seq -- 여기까지만 실행하면 값이 1씩 증가함
START WITH 1 -- 처음시작할 숫자
INCREMENT BY 1 -- 증가할 값
--MINVALUE 1 -- 최소값
--MAXVALUE 10 -- 최대값
NOCYCLE --최대값 도달 시 순환여부 // CYCLE or NOCYCLE
NOCACHE; -- 시퀸스번호 캐시할 지 여부
