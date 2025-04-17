--SEQUENCE
-- 자동으로 증가하는 숫자 생성.

DROP SEQUENCE seq_test;
CREATE SEQUENCE seq_test -- 여기까지만 실행하면 값이 1씩 증가함
START WITH 1 -- 처음시작할 숫자
INCREMENT BY 1 -- 증가할 값
--MINVALUE 1 -- 최소값
--MAXVALUE 10 -- 최대값
NOCYCLE --최대값 도달 시 순환여부 // CYCLE or NOCYCLE
NOCACHE; -- 시퀸스번호 캐시할 지 여부

SELECT seq_test.NEXTVAL FROM dual; -- 실행할때 마다 값 증가
SELECT seq_test.CURRVAL FROM dual; --NEXTVAL로 생성된 값을 확인하고 싶을때 씀

DROP TABLE t2;
CREATE TABLE t2(
    tno NUMBER PRIMARY KEY,
    tname VARCHAR2(20)
);

INSERT INTO t2 (tno, tname) VALUES (seq_test.nextval, 'test6');
select * from t2;

CREATE TABLE t2_cpy 
AS SELECT * FROM t2 WHERE tno = 1;
SELECT * FROM t2_cpy;

MERGE INTO t2_cpy
USING t2
ON (t2.tno = t2_cpy.tno) -- 기준 
WHEN MATCHED THEN  --기준에 맞는 것들이 있다면
UPDATE SET t2_cpy.tname = t2.tname -- 이렇게 업데이트 해라
WHEN NOT MATCHED THEN -- 기준에 맞는것이 없다면
INSERT VALUES (t2.tno, t2.tname); -- t2의 자료들을 INSERT 해라

SELECT * FROM t2_cpy;

UPDATE t2 SET tname = 'xxx' WHERE tno=2;

SELECT * FROM t2;

INSERT INTO t2 VALUES (seq_test.nextval, 'test4');

DROP TABLE parent;
CREATE TABLE parent(
id NUMBER PRIMARY KEY,
name VARCHAR2(100)
);

DROP TABLE child;
CREATE TABLE child(
id NUMBER PRIMARY KEY,
parent_id NUMBER,
constraint fk_parent FOREIGN KEY (parent_id)
REFERENCES parent(id)
ON DELETE CASCADE --  해당 외래키 지정시 부모테이블에서 데이터를 지우면 자식테이블 자료도 사라짐
);

INSERT INTO parent VALUES (1, 'AAA');
INSERT INTO child VALUES (1, 1);

DELETE FROM child WHERE id = 1;
DELETE FROM parent WHERE id = 1;
commit;

select * FROM parent;
select * FROM child;


CREATE TABLE customer (
c_code NUMBER PRIMARY KEY,
c_name VARCHAR2(30),
c_ceo VARCHAR2(30),
c_addr VARCHAR2(100),
c_phone CHAR(13)
);

CREATE TABLE product(
p_code NUMBER PRIMARY KEY,
p_name VARCHAR2(30),
p_cost NUMBER(10),
p_group VARCHAR2(30)
);

DROP TABLE stock;
CREATE TABLE stock(
p_code NUMBER,
s_qty VARCHAR2(30),
FOREIGN KEY (p_code)
REFERENCES product(p_code)
);

DROP TABLE trade;
CREATE TABLE trade(
t_seq NUMBER PRIMARY KEY,
p_code NUMBER,
c_code NUMBER,
t_date VARCHAR2(50),
t_qty VARCHAR2(30),
t_class VARCHAR2(30),
FOREIGN KEY (p_code)
REFERENCES product(p_code),
FOREIGN KEY (c_code)
REFERENCES customer(c_code)
);








