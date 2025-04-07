CREATE TABLE student (STU_NO CHAR(9) PRIMARY KEY,STU_NAME VARCHAR2(32),STU_DEPT VARCHAR2(20),STU_GRADE NUMBER(1), STU_CLASS CHAR(1), STU_GENDER CHAR(1), STU_HEIGHT NUMBER(5,2),STU_WEIGHT NUMBER(5,2));
DROP TABLE student;
CREATE TABLE student (STU_NO CHAR(9),STU_NAME VARCHAR2(32),STU_DEPT VARCHAR2(20),STU_GRADE NUMBER(1), STU_CLASS CHAR(1), STU_GENDER CHAR(1), STU_HEIGHT NUMBER(5,2),STU_WEIGHT NUMBER(5,2),CONSTRAINT p_STU_NO PRIMARY KEY(STU_NO));
CREATE TABLE enroll  (SUB_NO CHAR(3), STU_NO CHAR(9), ENG_GRADE NUMBER(3), CONSTRAINT p_course PRIMARY KEY(SUB_NO, STU_NO));
CREATE TABLE subject (SUB_NO CHAR(3), SUB_NAME VARCHAR2(30), SUB_PROF VARCHAR2(20), SUB_GRADE NUMBER(1), SUB_DEPT VARCHAR2(20), CONSTRAINT p_SUB_NO PRIMARY KEY(SUB_NO));
INSERT INTO student VALUES (20153075, '옥한빛', '기계', 1, 'C', 'M', 177, 80);
INSERT INTO student VALUES (20153088, '이태연', '기계', 1, 'C', 'F', 162, 50);
INSERT INTO student VALUES (20143054, '유가인', '기계', 2, 'C', 'F', 154, 47);
INSERT INTO student VALUES (20152088, '조민우', '전기전자', 1, 'C', 'M', 188, 90);
INSERT INTO student VALUES (20142021, '심수정', '전기전자', 2, 'A', 'F', 168, 45);
INSERT INTO student VALUES (20132003, '박희철', '전기전자', 3, 'B', 'M', NULL, 63);
INSERT INTO student VALUES (20151062, '김인중', '컴퓨터정보', 1, 'B', 'M', 166, 67);
INSERT INTO student VALUES (20141007, '진현무', '컴퓨터정보', 2, 'A', 'M', 174, 64);
INSERT INTO student VALUES (20131001, '김종헌', '컴퓨터정보', 3, 'C', 'M', NULL, 72);
INSERT INTO student VALUES (20131025, '옥성우', '컴퓨터정보', 3, 'A', 'F', 172, 63);

SELECT * FROM student;



INSERT INTO enroll VALUES ('101', '20131001', 80);
INSERT INTO enroll VALUES ('104', '20131001', 56);
INSERT INTO enroll VALUES ('106', '20132003', 72);
INSERT INTO enroll VALUES ('103', '20152088', 45);
INSERT INTO enroll VALUES ('101', '20131025', 65);
INSERT INTO enroll VALUES ('104', '20131025', 65);
INSERT INTO enroll VALUES ('108', '20151062', 81);
INSERT INTO enroll VALUES ('107', '20143054', 41);
INSERT INTO enroll VALUES ('102', '20153075', 66);
INSERT INTO enroll VALUES ('105', '20153075', 56);
INSERT INTO enroll VALUES ('102', '20153088', 61);
INSERT INTO enroll VALUES ('105', '20153088', 78);

DROP TABLE subject;
CREATE TABLE subject (SUB_NO CHAR(3), SUB_NAME VARCHAR2(30), SUB_PROF VARCHAR2(20), SUB_GRADE NUMBER(1), SUB_DEPT VARCHAR2(20), CONSTRAINT p_SUB_NO PRIMARY KEY(SUB_NO));
INSERT INTO subject VALUES ('111', '데이터베이스', '이재영', 2, '컴퓨터정보');
INSERT INTO subject VALUES ('110', '자동제어', '정순정', 2, '전기전자');
INSERT INTO subject VALUES ('109', '자동화설계', '박민영', 3,'기계');
INSERT INTO subject VALUES ('101', '컴퓨터개론', '강종영', 3,'컴퓨터정보');
INSERT INTO subject VALUES ('102', '기계공작법', '김태영', 1, '기계');
INSERT INTO subject VALUES ('103', '기초전자실험', '김유석', 1, '전기전자');
INSERT INTO subject VALUES ('104', '시스템분석설계', '강석현', 3,'컴퓨터정보');
INSERT INTO subject VALUES ('105', '기계요소설계', '김명성', 1,'기계');
INSERT INTO subject VALUES ('106', '전자회로실험', '최영민', 3,'전기전자');
INSERT INTO sunject VALUES ('107', 'CAD응용실습', '구봉규', 2,'기계');
INSERT INTO sunject VALUES ('108', '소프트웨어공학', '권민성', 1, '컴퓨터정보');

SELECT * from subject;

--학생테이블의 구조를 확인하시오.
DESCRIBE student;

--과목테이블의 구조를 확인하시오.
DESCRIBE subject;

--과목테이블의 구조를 확인하시오.
DESCRIBE enroll;

-- 학생테이블의 학번, 학생이름을 조회하시오.
SELECT STU_NO, STU_NAME
FROM student;

-- 학생테이블에서 학과를 중복데이터 없이 조회하시오.(DISTINCT)
SELECT DISTINCT STU_DEPT
FROM student;

-- 학생테이블에서 학년과 반을 중복없이 조회하시오.
SELECT DISTINCT STU_GRADE, STU_CLASS
FROM student;

-- 수강테이블에서 학번, 과목번호, 점수, 기존점수에 10을 더한 점수를 조회하시오.
SELECT STU_NO, SUB_NO, ENG_GRADE, ENG_GRADE + 10
FROM enroll;

-- 수강테이블에서 학번, 과목번호, 점수, 기존점수에 10을 더한 점수를 조회하시오.
-- 이때, 기존점수에 10을더한 점수의 열 제목은 plus10으로 하시오. (별칭 사용 : ALIAS)
SELECT STU_NO, SUB_NO, ENG_GRADE, ENG_GRADE + 10 as plus10
FROM enroll;

-- 연결 연산자 사용 : 두 개 이상의 열을 합쳐서 조회할 수 있음.
SELECT STU_DEPT || STU_NAME As 학과성명 FROM student;

SELECT STU_DEPT || ',' || STU_NAME || '입니다.' AS 학과성명 FROM student;

-- WHERE 절 사용하기
-- 학과가 '컴퓨터정보'인 학생의 이름, 학과, 학년, 반 정보를 조회하시오
SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT = '컴퓨터정보';

--학과가 '컴퓨터정보'가 아닌 학생의 이름, 학과, 학년, 반 정보를 조회하시오.
SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_CLASS
FROM student
WHERE STU_DEPT ^= '컴퓨터정보';

-- 학과가 컴퓨터정보이고 2학년인 학생의 모든 정보를 조회하시오.
SELECT * FROM student
WHERE STU_DEPT = '컴퓨터정보' AND STU_GRADE = 2;

-- 1학년, 2학년 학생의 모든 정보를 조회하시오.
SELECT * FROM student
WHERE STU_GRADE = 1 OR STU_GRADE = 2;

-- 체중이 60 이상 70이하인 학생의 이름과 학과, 학년을 조회하시오.
SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_WEIGHT >= 60 AND STU_WEIGHT <= 70; 

SELECT STU_NAME, STU_DEPT, STU_GRADE, STU_WEIGHT
FROM student
WHERE STU_WEIGHT BETWEEN 50 AND 72;

SELECT * FROM student;

--키가 180이상인 학생의 이름과 학과, 학년을 조회하시오.
SELECT STU_NAME, STU_DEPT, STU_GRADE
FROM student
WHERE STU_HEIGHT >= 180; 

--키가 10이상인 학생의 수는 몇 명인지 조회하시오.
SELECT COUNT(STU_NO)
FROM student
WHERE stu_height >= 170;

--LIKE를 이용한 검색
--LIKE와 함꼐 쓰이는 기호(와일드카드) % , _(언더바)
-- % : 0개 이상의 문자
-- _ : 1개의 문자

-- 학생 중 성이 김씨인 학생들의 정보를 검색하시오.
SELECT * FROM student
WHERE stu_name LIKE '김%';

-- 학생 중 이름의 두번째 글자가 '수'인 학생의 이름을 검색하시오
SELECT stu_name FROM student
WHERE stu_name LIKE '_수%';

-- 학생 중 이름이 '우'로 끝나는 학생의 수가 몇명인지 검색하시오
SELECT COUNT(STU_NO)
FROM student
WHERE stu_name LIKE '__우%';

-- 학번이 2014번인 학생의 정보를 조회하시오.
SELECT * FROM student
WHERE stu_no LIKE '2014%';

-- NULL 확인
SELECT stu_no, stu_name, stu_height FROM student;

-- 학생정보 중 키 값이 없는 학생의 학번, 이름, 키를 조회하시오
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NULL;

-- 학생정보 중 키 값이 있는 학생의 학번, 이름, 키를 조회하시오
SELECT stu_no, stu_name, stu_height
FROM student
WHERE stu_height IS NOT NULL;

-- 학과가 '컴퓨터정보' 이거나 '기계'과인 학생의 학번과 이름, 학과를 검색하시오.
SELECT stu_no, stu_name, stu_dept
FROM student
WHERE stu_dept = '컴퓨터정보' OR stu_dept='기계';

SELECT stu_no, stu_name, stu_dept
FROM student
WHERE stu_dept IN ('컴퓨터정보', '기계');

--정렬하기(오름차순, 내림차순)
--오름차순 : ASC(기본)
--내림차순 : DESC
SELECT * FROM student
ORDER BY stu_no ASC;

SELECT * FROM student
ORDER BY stu_no DESC;

SELECT stu_no, stu_name, stu_dept, stu_weight-5 AS target
FROM student
ORDER BY target;

SELECT stu_no, stu_name, stu_dept, stu_weight-5 AS target
FROM student
ORDER BY stu_dept, target DESC; --학과를 먼저 정렬하고 타겟을 정렬함

SELECT stu_no, stu_name, stu_dept, stu_weight-5 AS target
FROM student
ORDER BY stu_height ;

--남학생의 이름, 학과, 학년을 조회하시오.
SELECT stu_no, stu_dept, stu_grade
FROM student
WHERE stu_gender = 'M';
--학생들의 이름과 현재 체중, 그리고 현재 체중에 5를 더한 체중값을 조회하시오 이때 별칭을 plus5로 하시오
SELECT stu_name, stu_weight, stu_weight+5 AS plus5
FROM student;
--수강테이블의 모든정보를 검색하시오 이때 별칭을 한글로 부여하여 검색하시오
SELECT stu_no AS 학번, sub_no AS 과목코드, eng_grade AS 점수
FROM enroll;
--학생의 이름과 학과를 컴퓨터정보과 옥한빛입니다. 식으로 검색하시오
SELECT stu_dept || '과' || ' ' || stu_name || '입니다'
FROM student;
--전기전자과 이외의 학생들의 모든 정보를 검색하시오.
SELECT * FROM student
WHERE stu_dept ^= '전기전자';
-- 기계과 이면서 2학년인 학생들의 모든정보를 검색하시오
SELECT * FROM student
WHERE stu_dept = '기계' AND stu_grade=2;
-- 여학생 중 체중이 60이하인 학생을 모두 검색하시오
-- 키가 160이상이며 170이하인 학생의 학번과 이름을 검색하시오
-- 이름에 '옥'이 들어있는 학생의 이름을 검색하시오.
-- 키가 NULL인 학생의 이름을 검색하시오
-- 키가 NULL이 아닌 학생의 이름을 검색하시오
-- 학번이 'XXXX20XX'인 학생의 모든 정보를 검색하시오
-- 학번이 2014인 학생들을 이름순으로 조회하시오(오름차순)
-- 학과 정보를 이름을 기준으로 내림차순으로 검색하시오