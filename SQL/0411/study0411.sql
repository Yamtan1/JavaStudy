CREATE TABLE t_student
AS SELECT * FROM student WHERE stu_dept = '기계';

desc t_student;

SELECT * FROM t_student;

--새로운 열 추가 
ALTER TABLE t_student ADD (army CHAR(1)); --여러개 추가하고 싶으면 콤마하고 추가하면됨
ALTER TABLE t_student ADD (age NUMBER(3) DEFAULT 20); -- 디폴트 = 기본값을 20으로 주겟다 라는 기본값 설정
--열 삭제
ALTER TABLE t_student DROP COLUMN age;  --여러개 추가하고 싶으면 콤마하고 추가하면됨

DESC t_student;
select * from t_student;

UPDATE t_student SET age = 22 
WHERE stu_name = '이태연';
UPDATE t_student SET age = 25 
WHERE stu_name = '유가인';

ALTER TABLE t_student  DROP (army); 
ALTER TABLE t_student ADD army CHAR(1);

--테이블 이름 변경
RENAME t_student TO test_student;

DESC test_student;

-- 테이블 내 데이터 삭제  (DELETE가 있지만 DELETE는 커밋을해야 반영이됨. 얘는 커밋을 안해도 바로 반영이됨.)
DELETE FROM test_student;
ROLLBACK;
TRUNCATE TABLE test_student; --ROLLBACK해도 안돌아옴 

select * from test_student;

DROP TABLE test_student;

-- 제약 조건
-- 데이터베이스 상태(인스턴스) 가 항상 만족해야할 기본 규칙

CREATE TABLE t2(
    mno NUMBER PRIMARY KEY,
    mobile CHAR(13) UNIQUE NOT NULL,--기본 키가 설정되어있으니 유니크로 중복이 안되게 제약조건 설정
    gender CHAR(1)  CHECK (gender IN('M', 'F')), --성별은 남, 여밖에 없으니 다른 값이 들어오지 못하게 설정
    hobby VARCHAR2(30) NOT NULL --값을 무조건 입력하도록 제약조건 설정
);

INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (1, NULL, NULL, '코딩');
INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (2, '010-1111', NULL, '코딩');
INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (3, '010-1111-2222', NULL, '코딩');
INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (4, '010-1324-4684', 'M', '달리기');

SELECT * FROM t2;

ALTER TABLE t2 DISABLE CONSTRAINT SYS_C007520; --제약조건 일시적으로 풀기
INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (5, '010-4444-7878', 'F', null);

ALTER TABLE t2 ENABLE CONSTRAINT SYS_C007520;  --제약조건 다시 활성화 (null값이 있어서 작동을 안하므로 수정을 통해 null데이터를 바꾼 후 실행해야함)
UPDATE t2 SET hobby = '걷기' WHERE mno = 5;

ALTER TABLE t2 DROP CONSTRAINT SYS_C007520; --제약조건 삭제

INSERT INTO t2(mno, mobile, gender, hobby)
VALUES (6, '010-2354-8758', 'F', null);

DROP TABLE t2;














