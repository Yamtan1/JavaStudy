-- 1 부서번호가 20 30인 자료들로 테이블 만들고 emp1;
CREATE TABLE emp1
AS SELECT * FROM emp WHERE deptno IN (20, 30);
SELECT * FROM emp1;
-- 2 dept 테이블을 바탕으로 dept1 테이블을 만드시오
CREATE TABLE dept1
AS SELECT * FROM dept;
SELECT * FROM dept1;
-- 3 salgarde 테이블을 바탕으로 salgrade1 테이블을 만드시오
CREATE TABLE salgrade1
AS SELECT * FROM salgrade;
SELECT * FROM salgrade1;
INSERT INTO salgrade1 VALUES(1, 700, 1200);
INSERT INTO salgrade1 VALUES(2, 1201, 1400);
INSERT INTO salgrade1 VALUES(3, 1401, 2000);
INSERT INTO salgrade1 VALUES(4, 2001, 3000);
INSERT INTO salgrade1 VALUES(5, 3001, 9999);
-- 4 사원번호 7703, 사원이름 JOSH, 사원직문 SALESMAN, 상급자사원번호 7566, 급여 1400, 커미션 0, 부서번호20인 사원이 오늘 입사하였다.
INSERT INTO emp1 VALUES (7703, 'JOSH', 'SALESMAN', 7566, SYSDATE, 1400, 0, 20);
-- 5 사원번호 7401, 사원이름 HOMER, 급여 1300, 부서번호 10인 사원이 입사하였다.
INSERT INTO emp1 VALUES (7401, 'HOMER', NULL, NULL, SYSDATE, 1300, NULL ,10);
-- 6 사원번호 7323, 사원이름 BRANDA, 부서번호30, 사원번호 7499와 동일한 급여를 받는 사원이 입사하였다.
INSERT INTO emp1 VALUES (7323, 'BRANDA', NULL, NULL, SYSDATE, 1600, NULL, 30);
-- 7 사원(emp) 테이블에서 부서번호가 10인 데이터를 epm1테이블에 삽입하시오
INSERT INTO emp1
SELECT * FROM emp
WHERE deptno = 10;
-- 8 사원번호 7369의 사원직무를 ALALYST로 바꾸시오
UPDATE emp1 SET job = 'ALALYST' WHERE empno = 7369;
-- 9 부서번호 20인 직원들의 급여를 10% 감하시오
UPDATE emp1
SET sal = sal * 0.9
WHERE deptno = 20;
-- 10 모든사원의 급여를 100증가시키시오
UPDATE emp1
SET sal = sal + 100;
-- 11 사원번호 7902의 상급자 사원번호를 7654, 부서번호를 30으로 바꾸시오
UPDATE emp1
SET mgr = 7654, deptno = 30
WHERE empno = 7902;
-- 12 지역이 DALLAS인 사원들의 급여를 10 감하시오
UPDATE emp1
SET sal = sal - 10
WHERE deptno IN (SELECT deptno FROM dept1 WHERE loc = 'DALLAS');
-- 13 급여 등급이 2인 사원들의 급여를 20감하시오
UPDATE emp1
SET sal = sal - 20
WHERE sal BETWEEN (SELECT losal FROM salgrade1 WHERE grade = 2) AND (SELECT hisal FROM salgrade1 WHERE grade = 2);
-- 14 사원번호 7499가 퇴사하였다
DELETE FROM emp1
WHERE empno = 7499;
-- 15 부서번호 50, 부서이름 'PLANNING', 지역 'MIAMI'가 추가되었다
INSERT INTO dept1 VALUES (50, 'PLANNING', 'MIAMI');
-- 16 부서번호가 40인 부서가 60으로 변경되었다
UPDATE dept1 
SET deptno =60
WHERE deptno = 40;
-- 17 부서번호가 30인 부서가 폐쇄되었다.
DELETE FROM dept1
WHERE deptno = 30;
-- 18 dept1 테이블에 없는 부서번호들을 갖고 있는 사원들의 부서번호를 99로 변경하시오
UPDATE emp1
SET deptno = 99
WHERE deptno NOT IN(SELECT deptno FROM dept1);
-- 19 epm1에서 99번 부서번호를 삭제하시오
DELETE FROM emp1
WHERE deptno = 99;
-- 20 상급자사원번호가 없는 사원의 급여를 100 올렸다
UPDATE emp1
SET sal = sal+100
WHERE mgr IS NULL;
-- 21 JONES, JOSH, CLARK가 30번 부서로 바뀌었다
UPDATE emp1
SET deptno = 30
WHERE ename = 'CLARK';
-- 22 커미션이 NULL인 데이터를 0으로바꾸시오
UPDATE emp1
SET comm = 0
WHERE comm IS NULL;
-- 23 epm1 전체 테이블의 데이터를 삭제하시오
TRUNCATE TABLE emp1;
------------------------------------------------------------------------------------------------------------------------------------------------------

-- 1, 2학년 학생정보로 student1 테이블을 생성하시오
CREATE TABLE student1
AS SELECT * FROM student WHERE stu_grade IN (1, 2);
SELECT * FROM student1;
-- subject테이블을 바탕으로 subject1 테이블을 생성하시오
CREATE TABLE subject1
AS SELECT * FROM subject;
SELECT * FROM subject1;
-- enroll 테이블을 바탕으로 enroll1테이블을 생성하시오
CREATE TABLE enroll1
AS SELECT * FROM enroll;
SELECT * FROM enroll1;
-- 1 학번20101059, 이름 조병준, 학과 컴퓨터 정보, 학년 1, 반 B, 키 164, 몸무게 70인 남학생이 추가되었다
INSERT INTO student1 VALUES ('20101059', '조병준','컴퓨터정보',1,'B', 'M', 164,70);
-- 2 학번 20102038, 이름 남지선 ,학과 전기전자, 학년 1, 반 C , 여학생이 추가되었다
INSERT INTO student1 VALUES ('20102038', '남지선', '전기전자', 1,'C','F',NULL,NULL);
-- 3 학번 20103009, 이름 박소신, 학과 기계, 20153075학생과 같은 학년 반을 갖는 남학생이 추가되었다
INSERT INTO student1(stu_no, stu_name, stu_dept, stu_grade, stu_class, stu_gender, stu_height, stu_weight)
SELECT '20103009','박소신', '기계',  stu_grade, stu_class, 'M', NULL, NULL
FROM student1
WHERE stu_no = '20153075';
-- 4 student1 테이블에 학생(student) 테이블의 3학년 학생들 데이터를 입력하시오
INSERT INTO student1
SELECT * FROM student WHERE stu_grade = 3;
-- 5 학번 20131001의 반을 B로 바꾸시오
UPDATE student1
SET stu_class = 'B'
WHERE stu_no = '20131001';
-- 6 20152088 학생의 키가 2cm자랐다
UPDATE student1
SET stu_height = stu_height + 2
WHERE stu_no = '20152088';
-- 7 모든학생의 학년이 올랐다
UPDATE student1
SET stu_grade = stu_grade + 1;
-- 8 20142021의 학생의 학과를 컴퓨터정보로 바꾸시오(단 학번은 입학년도 + 학과코드+일렬번호, 학과코드 1: 컴퓨터정보, 2:전자전자, 3:기계)
UPDATE student1
SET stu_dept = '컴퓨터정보' , stu_no = '20141001'
WHERE stu_no = '20142021';
--9 전자회로실험 과목의 점수를 1점 감하시오
UPDATE enroll1
SET eng_grade = eng_grade - 1
WHERE sub_no IN (SELECT sub_no FROM subject1 WHERE sub_name = '전자회로실험');
-- 10 20151062학생이 소프트웨어공학 시험중 부정행위로 0점이 되었다
UPDATE enroll1
SET eng_grade = 0
WHERE  sub_no = 108 AND stu_no = '20151062';
-- 11 20153088학생이 자퇴하였다
DELETE FROM student1
WHERE stu_no = '20153088';
-- 12 과목번호 112, 과목이름 자동화시스템, 교수명 고종민, 학년 3, 학과 기계를 추가하시오
INSERT INTO subject1 VALUES ('112','자동화시스템','고종민',3,'기계');
-- 13 과목번호가 110에서 501로 변경되었다
UPDATE subject1
SET sub_no = 501
WHERE sub_no = 110;
-- 14 과목번호 101이 폐강되었다
DELETE subject1
WHERE sub_no = 101;
-- 15 enroll1 테이블에서 subject1에 없는 과목번호를 999로 변경하시오
UPDATE enroll1
SET sub_no = 999
WHERE sub_no NOT IN (SELECT sub_no FROM subject1);
-- 16 enroll1 테이블에서 student1에 없는 학번을 99999999로 변경하시오
UPDATE enroll1
SET stu_no = 99999999
WHERE stu_no NOT IN (SELECT stu_no FROM student1);
-- 17 enroll1 테이블에서 과목번호 999를 삭제하시오
DELETE FROM enroll1
WHERE sub_no = 999;
-- 18 enroll1 테이블에서 학번 99999999를 삭제하시오
DELETE FROM enroll1
WHERE stu_no = 99999999;
-- 19 enroll1 테이블에 없는 과목을 삭제하시오
DELETE FROM subject1
WHERE sub_no NOT IN (SELECT sub_no FROM enroll1);
-- 20 enroll1 테이블의 전체데이터를 삭제하시오
TRUNCATE TABLE enroll1;