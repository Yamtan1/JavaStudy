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
SELECT * FROM student
WHERE stu_gender = 'F' AND stu_weight <= 60;
-- 키가 160이상이며 170이하인 학생의 학번과 이름을 검색하시오
SELECT stu_no, stu_name
FROM student
WHERE stu_height BETWEEN 160 AND 170;
-- 이름에 '옥'이 들어있는 학생의 이름을 검색하시오.
SELECT stu_name
FROM student
WHERE stu_name LIKE '옥%';
-- 키가 NULL인 학생의 이름을 검색하시오
SELECT stu_name
FROM student
WHERE stu_height IS NULL;
-- 키가 NULL이 아닌 학생의 이름을 검색하시오
SELECT stu_name
FROM student
WHERE stu_height IS NOT NULL;
-- 학번이 'XXXX20XX'인 학생의 모든 정보를 검색하시오
SELECT * FROM student
WHERE stu_no LIKE '____20__%';
-- 학번이 2014인 학생들을 이름순으로 조회하시오(오름차순)
SELECT * FROM student
WHERE stu_no LIKE '2014%'
ORDER BY stu_name;
-- 학과 정보를 이름을 기준으로 내림차순으로 검색하시오

-- 그룹
-- MAX, MIN
SELECT MAX(stu_height) FROM student;
SELECT MIN(stu_weight) FROM student;

--SUM
SELECT SUM(eng_grade) FROM enroll;

--COUNT
SELECT COUNT(*), COUNT(stu_height) FROM student;

--GROUP BY 그룹바이에서 선택한 컬럼이 셀렉트에도 같이와야함
--학생테이블에서 학과별 몸무게 평균을 구하시오.
SELECT stu_dept, avg(stu_weight)
FROM student
GROUP BY stu_dept;

--학생테이블에서 체중이 50이상의 학생들의 학과별 인원수를 구하시오.
SELECT stu_dept, COUNT(*)  
FROM student
WHERE stu_weight >= 50
GROUP BY stu_dept;

--학생테이블에서 학과별 학년별 인원수를 구하시오
SELECT stu_dept, stu_grade, COUNT(*)
FROM student
GROUP BY stu_dept, stu_grade
ORDER BY stu_dept;

--기계과 학생들 중 학년별 평군 신장이 160이상인 학년과 평균 신장을 구하시오.
SELECT stu_grade, AVG(stu_height)
FROM student WHERE stu_dept ='기계'
GROUP BY stu_grade
HAVING AVG(stu_height) >= 160; --그룹화한 상태에서 조건을 걸때 HAVING을 씀

--최대신장이 175 이상인 학과들을 구하고 학과별 최대 신장을 구하시오
SELECT stu_dept, MAX(stu_height)
FROM student
GROUP BY stu_dept
HAVING MAX(stu_height) >= 175;

--학과별 평균 신장 중 가장 높은 평균 신장을 구하시오
SELECT to_char(MAX(AVG(stu_height)), '999.99')
FROM student
GROUP BY stu_dept;


-------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE dept(deptno CHAR(2), dname VARCHAR(14), loc VARCHAR(13));
DROP TABLE dept;

CREATE TABLE dept(deptno CHAR(2), dname VARCHAR(14), loc VARCHAR(13),CONSTRAINT p_deptno PRIMARY KEY(deptno));
CREATE TABLE salgrade (grade CHAR(2), losal NUMBER(7), hisal NUMBER(7),CONSTRAINT p_grade PRIMARY KEY(grade));
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
SELECT * FROM student
WHERE stu_gender = 'F' AND stu_weight <= 60;
-- 키가 160이상이며 170이하인 학생의 학번과 이름을 검색하시오
SELECT stu_no, stu_name
FROM student
WHERE stu_height BETWEEN 160 AND 170;
-- 이름에 '옥'이 들어있는 학생의 이름을 검색하시오.
SELECT stu_name
FROM student
WHERE stu_name LIKE '옥%';
-- 키가 NULL인 학생의 이름을 검색하시오
SELECT stu_name
FROM student
WHERE stu_height IS NULL;
-- 키가 NULL이 아닌 학생의 이름을 검색하시오
SELECT stu_name
FROM student
WHERE stu_height IS NOT NULL;
-- 학번이 'XXXX20XX'인 학생의 모든 정보를 검색하시오
SELECT * FROM student
WHERE stu_no LIKE '____20__%';
-- 학번이 2014인 학생들을 이름순으로 조회하시오(오름차순)
SELECT * FROM student
WHERE stu_no LIKE '2014%'
ORDER BY stu_name;
-- 학과 정보를 이름을 기준으로 내림차순으로 검색하시오

-- 그룹
-- MAX, MIN
SELECT MAX(stu_height) FROM student;
SELECT MIN(stu_weight) FROM student;

--SUM
SELECT SUM(eng_grade) FROM enroll;

--COUNT
SELECT COUNT(*), COUNT(stu_height) FROM student;

--GROUP BY 그룹바이에서 선택한 컬럼이 셀렉트에도 같이와야함
--학생테이블에서 학과별 몸무게 평균을 구하시오.
SELECT stu_dept, avg(stu_weight)
FROM student
GROUP BY stu_dept;

--학생테이블에서 체중이 50이상의 학생들의 학과별 인원수를 구하시오.
SELECT stu_dept, COUNT(*)  
FROM student
WHERE stu_weight >= 50
GROUP BY stu_dept;

--학생테이블에서 학과별 학년별 인원수를 구하시오
SELECT stu_dept, stu_grade, COUNT(*)
FROM student
GROUP BY stu_dept, stu_grade
ORDER BY stu_dept;

--기계과 학생들 중 학년별 평군 신장이 160이상인 학년과 평균 신장을 구하시오.
SELECT stu_grade, AVG(stu_height)
FROM student WHERE stu_dept ='기계'
GROUP BY stu_grade
HAVING AVG(stu_height) >= 160; --그룹화한 상태에서 조건을 걸때 HAVING을 씀

--최대신장이 175 이상인 학과들을 구하고 학과별 최대 신장을 구하시오
SELECT stu_dept, MAX(stu_height)
FROM student
GROUP BY stu_dept
HAVING MAX(stu_height) >= 175;

--학과별 평균 신장 중 가장 높은 평균 신장을 구하시오
SELECT to_char(MAX(AVG(stu_height)), '999.99')
FROM student
GROUP BY stu_dept;


-------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE dept(deptno CHAR(2), dname VARCHAR(14), loc VARCHAR(13));
DROP TABLE dept;

CREATE TABLE dept(deptno CHAR(2), dname VARCHAR(14), loc VARCHAR(13),CONSTRAINT p_deptno PRIMARY KEY(deptno));
CREATE TABLE salgrade (grade CHAR(2), losal NUMBER(7), hisal NUMBER(7),CONSTRAINT p_grade PRIMARY KEY(grade));
CREATE TABLE emp(
empno CHAR(3), ename VARCHAR2(30), job VARCHAR(20), mgr CHAR(4), hiredate DATE, sal NUMBER(7), comm NUMBER(7), deptno CHAR(2),CONSTRAINT p_empno PRIMARY KEY(empno));
DROP TABLE dept;
DROP TABLE salgrade;
CREATE TABLE dept(deptno CHAR(2), dname VARCHAR2(14), loc VARCHAR2(13),CONSTRAINT p_deptno PRIMARY KEY(deptno));
CREATE TABLE salgrade (grade CHAR(2), losal NUMBER(7), hisal NUMBER(7),CONSTRAINT p_grade PRIMARY KEY(grade));





DROP TABLE dept;
DROP TABLE salgrade;
CREATE TABLE dept(deptno CHAR(2), dname VARCHAR2(14), loc VARCHAR2(13),CONSTRAINT p_deptno PRIMARY KEY(deptno));
CREATE TABLE salgrade (grade CHAR(2), losal NUMBER(7), hisal NUMBER(7),CONSTRAINT p_grade PRIMARY KEY(grade));
DROP TABLE emp;


INSERT INTO dept VALUES (10, 'ACCOUNTING', 'NEW YORK');

CREATE TABLE emp(
    empno CHAR(4) PRIMARY KEY,
    ename VARCHAR2(30),
    job VARCHAR2(20),
    mgr CHAR(4),
    hiredate DATE,
    sal NUMBER(7,2),
    comm NUMBER(7,2),
    deptno CHAR(2),
    FOREIGN KEY(mgr) REFERENCES emp(empno),
    FOREIGN KEY(deptno) REFERENCES dept(deptno)  
);

INSERT INTO dept VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES (40, 'OPERATIONS', 'BOSTON');

INSERT INTO emp 
VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('17-11-1981', 'dd-mm-yyyy'), 5000, NULL, 10);

INSERT INTO emp 
VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('2-4-1981', 'dd-mm-yyyy'), 2975, NULL, 20);

INSERT INTO emp 
VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1-5-1981', 'dd-mm-yyyy'), 2850, NULL, 30);

INSERT INTO emp 
VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('9-6-1981', 'dd-mm-yyyy'), 2450, NULL, 10);

INSERT INTO emp 
VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('13-7-1987', 'dd-mm-yyyy'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('3-12-1981', 'dd-mm-yyyy'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('20-2-1981', 'dd-mm-yyyy'), 1600, 300, 30);

INSERT INTO emp 
VALUES (7521, 'WORD', 'SALESMAN', 7698, TO_DATE('22-2-1981', 'dd-mm-yyyy'), 1250, 500, 30);

INSERT INTO emp 
VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('28-9-1981', 'dd-mm-yyyy'), 1250, 1400, 30);

INSERT INTO emp 
VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('8-9-1981', 'dd-mm-yyyy'), 1500, 0, 30);

INSERT INTO emp 
VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('3-12-1981', 'dd-mm-yyyy'), 950, NULL, 30);

INSERT INTO emp 
VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('23-1-1982', 'dd-mm-yyyy'), 1300, NULL, 10);

INSERT INTO emp 
VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('17-12-1980', 'dd-mm-yyyy'), 800, NULL, 20);

INSERT INTO emp 
VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('13-7-1987', 'dd-mm-yyyy'), 1100, NULL, 20);

SELECT * FROM emp;

SELECT * FROM salgrade;
-- 반올림
SELECT ROUND(345.678), ROUND(345.678, 0), ROUND(345.678, 1), ROUND(345.678, -1)
FROM DUAL;

--오라클 숫자 함수
SELECT ABS(-19) FROM DUAL;
SELECT CEIL(3.14) FROM DUAL;
SELECT FLOOR(3.99) FROM DUAL;
SELECT TRUNC(123.456, 2) FROM DUAL;
SELECT MOD(10, 3) FROM DUAL;
SELECT POWER(2, 3) FROM DUAL;
SELECT SQRT(16) FROM DUAL;
SELECT SIGN(50) FROM DUAL; --숫자의 부호 반환[-1:음수, 0:0, 1:양수]


--오라클 문자열 함수
SELECT LENGTH('ORACLE') FROM DUAL;
SELECT SUBSTR('ORACLE', 2, 3) FROM DUAL;
SELECT INSTR('ORACLE', 'A') FROM DUAL;
SELECT UPPER('oracle') FROM DUAL;
SELECT LOWER('ORACLE') FROM DUAL;
SELECT INITCAP('hello oracle') FROM DUAL;
SELECT TRIM('O' FROM 'ORACLEO') FROM DUAL;
SELECT LTRIM('***ABC', '*') FROM DUAL;
SELECT RTRIM ('ABC***','*') FROM DUAL;
SELECT REPLACE ('a-b-c', '-', '+') FROM DUAL;
SELECT CONCAT ('HI', 'oracle') FROM DUAL;
SELECT LPAD ('99', 5, '0') FROM DUAL;
SELECT RPAD ('HI', 5, '!') FROM DUAL;
SELECT TRANSLATE('12345', '123', 'ABC') FROM DUAL;

--오라클 날짜 함수
SELECT SYSDATE AS 현재시간 FROM DUAL;
SELECT CURRENT_DATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 3) AS 세달후 FROM DUAL;
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2025-01-01', 'YYYY-MM-DD')) AS 개월차이 FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '월요일') AS 다음월요일 FROM DUAL;
SELECT LAST_DAY(SYSDATE) AS 이달마지막날 FROM DUAL;
SELECT ROUND(SYSDATE, 'MONTH') AS 반올림결과 FROM DUAL; --15일 이상이면 다음달
SELECT EXTRACT(YEAR FROM SYSDATE) AS 년도 FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) AS 달 FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE) AS 일 FROM DUAL;
SELECT TO_DATE('2025-03-24', 'YYYY-MM-DD') AS 날짜변환 FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT SYSDATE - TO_DATE('2025-02-27', 'YYYY-MM-DD') FROM DUAL;

SELECT TO_CHAR (TO_NUMBER(1234.5678), '9999.999') FROM DUAL;
SELECT TO_CHAR (TO_NUMBER(1234.5678), '9999.9999') FROM DUAL;
SELECT TO_CHAR (TO_NUMBER(1234.5678), '999.999') FROM DUAL;

SELECT empno, ename, TO_CHAR(TO_NUMBER(sal), '$9999') salary FROM emp;

SELECT ename, NVL (MGR, 0) FROM emp; --NVL (널이아니면 헤당컬럼값 출력[MGR], 널이면 해당값 출력[0])  해라 라는 뜻
SELECT ename, mgr FROM emp;

SELECT ename, job, comm, sal FROM emp;
SELECT ename, job, NVL2(comm, sal+comm, sal) FROM emp; --NVL2 는 커미션 컬럼에 있는 값이 널이면 샐러리값만 널이아니면 샐러리와 커미션값을 더해라

--1부서의  부서 이름과 지역을 검색하시오
SELECT dname, loc FROM dept;
--2사원들의 입사일 중복을 제거하고 검색하시오
SELECT DISTINCT hiredate FROM emp;
--3사원들의 부서번호 중복을 제거하고 검색하시오
SELECT DISTINCT empno FROM emp;
--4 사원들의 6개월 급여의 합을 검색하시오
SELECT ename, sal, sal * 6 AS div6 FROM emp;
--5 사원이름을 'Name'으로 사원의 급여를 'Salary'로 열의 이름을 부여하여 검색하시오
SELECT 'Name : ' || ename || ', Salary : ' || sal FROM emp;
--6부서번호 부서이름 지역을 한글 제목으로 검색하시오
SELECT  deptno AS 부서번호, loc AS 지역 FROM dept;
--7 사원의 직무와 사원이름을 합쳐서 검색하시오(예: PRESIDENTKING)
SELECT job || ename FROM emp;
--8. 10번 부서에서 근무하는 사원의 이름을 검색하시오
SELECT ename FROM emp
WHERE deptno = 10;
--9급여가 2000이상인 사원들의 사원번호 사원이름을 검색하시오
SELECT empno, ename FROM emp
WHERE sal >= 2000;
--10 사원직무가 'CLERK'인 사원들의 사원번호, 사원이름을 검색하시오
SELECT empno, ename FROM emp
WHERE job = 'CLERK';
--11 1980년 12월 17일에 입사한 사원의 이름을 검색하시오
SELECT ename FROM emp
WHERE hiredate = '1980-12-17';
--12 부서번호 30이외의 부서이름과 지역을 검색하시오
SELECT deptno, loc FROM dept
WHERE deptno ^=30;
--13 사원이름'WORD'를'WARD'로 수정하고 'WARD'  사원의 모든 정보를 검색하시오
UPDATE emp
SET ename = 'WARD'
WHERE ename = 'WORD';
SELECT * FROM emp
WHERE ename = 'WARD';
--14 10번부서에 근무하는 MANAGER의 사원이름을 검색하시오
SELECT ename FROM emp
WHERE deptno = 10 AND job ='MANAGER';
--15 급여가 2000이상이며, 30번 부서에 근무하는 사원들의 사원번호와 사원이름을 검색하시오
SELECT empno, ename FROM emp
WHERE sal >= 2000 AND deptno=30;
--16 20부서 외에 근무하는 MANAGER의 사원 이름을 검색하시오
SELECT ename FROM emp
WHERE job = 'MANAGER' AND deptno ^= 20;
--17 SALESMAN급여가 1500 이상인 사원 이름을 검색하시오.
SELECT ename FROM emp
WHERE job ='SALESMAN' AND sal >= 1500;
--18 사원번호가 75xx인 사원의 사원번호, 사원이름, 부서번호를 검색하시오
SELECT empno, ename, deptno FROM emp
WHERE empno LIKE '75__%';
--19 부서번호가 10 또는 30에 근무하는 사원들의 사원 이름과 급여를 검색하시오.
SELECT ename, sal FROM emp
WHERE deptno = 10 OR deptno=30;
--20 상급자 사원번호가 76으로 시작하는 사원들의 사원이름을 검색하시오.
SELECT ename FROM emp
WHERE mgr LIKE '76%';
--21 1981년 2월에 입사한 사원의 사원번호, 사원이름, 부서번호를 검색하시오
SELECT empno, ename, deptno FROM emp
WHERE hiredate BETWEEN '1981-02-01' AND '1981-02-28';
--22 사원이름 중간에 'A'가 들어있는 사원의 사원번호와 사원이름을 검색하시오
SELECT empno, ename FROM emp
WHERE ename LIKE '%A%';
--23 상급자가 사원번호가 NULL인 사원의 사원번호와 사원이름을 검색하시오
--24 상급자 사원번호가 NULL이 아닌 사원의 사원번호와 사원이름, 상급자 사원번호를 검색하시오 
--25 사원들의 사원번호와 사원이름을 사원번호 순으로 검색하시오(오름차순)
--26 사원들의 정보를 사원직무별 급여가 많은 순으로 검색하시오.
--27 사원들의 사원이름을 소문자로 검색하시오
--28 사원들의 사원이름, 사원직무를 대문자로 검색하시오
--29 사원들의 사원이름을 첫 자만 대문자로 검색하시오
--30 사원들의 사원이름과 사원직무를 연결(CONTACT)하여 검색하시오
--31 사원들의 사원이름과 사원이름의 첫 두 글자를 검색하시오
--32 사원들의 사원이름,사원직무 그리고 사원직무의 두 번째 부터 세글자를 검색하시오
--33 사원들의 사원이름과 사원이름의 길이를 검색하시오
--34 사원들의 사원이름에 'A'가 몇 번째 위치에 있는지 검색하시오
--35 사원이름을15자리로하고 뒤에 '&'를 채워 검색하시오
--36 사원직무를 20자리로 하고 앞에 '%'를 채워 검색하시오
--37 사원의 사원번호 사원이름 급여를 검색하시오 (급여는 두번째 자리에서 반올림함 - 예 2570 > 2700
--38 사원의 사원번호 사원이름 급여를 검색하시오 (급여는 두번째 자리에서 절삭함) 예 2975 > 2900
--40 사원번호 사원이름 입사일 입사후 100일의 날짜를 검색하시오
--41 사원번호 사원이름 입사일 근무 일자를 계산하여 검색하시오
--42 사원들의 입사일에서 3달째 되는 날짜를 검색하시오
--43 상급자 사원번호가 없는 사원의 경우 '상급자없음'을 나타내도록 하시오
--44 커미션을 포함한 급여를 사원번호 사원이름과 함께 검색하시오
--45 커미션을 포함한 연봉을 사원번호 사원이름과 함께 검색하시오

