CREATE TABLE tbl_product_202101(
pcode CHAR(4) PRIMARY KEY,
pname VARCHAR(30),
cost NUMBER(7));

CREATE TABLE tbl_shop_202101(
shopno CHAR(4) PRIMARY KEY,
shopname CHAR(20),
discount NUMBER(3) );

CREATE TABLE tbl_order_202101(
orderno CHAR(8) PRIMARY KEY,
shopno CHAR(4),
orderdate CHAR(8),
pcode CHAR(4),
amount NUMBER(5) );



INSERT INTO tbl_product_202101 VALUES ('AA01', '삼각김밥', 1000);
INSERT INTO tbl_product_202101 VALUES ('AA02', '도시락', 2500);
INSERT INTO tbl_product_202101 VALUES ('AA03', '봉지만두', 3000);
INSERT INTO tbl_product_202101 VALUES ('AA04', '컵라면', 1500);
INSERT INTO tbl_product_202101 VALUES ('AA05', '아메리카노', 2000);
INSERT INTO tbl_product_202101 VALUES ('AA06', '콜라', 800);

INSERT INTO tbl_shop_202101 VALUES ('S001', 'AA 할인점',10);
INSERT INTO tbl_shop_202101 VALUES ('S002', 'BB 할인점',15);
INSERT INTO tbl_shop_202101 VALUES ('S003', 'CC 할인점',10);
INSERT INTO tbl_shop_202101 VALUES ('S004', 'DD 할인점',15);

SELECT m.custno, m.custname, m.grade, m2.price
FROM member_tbl_02 m , money_tbl_02 m2
WHERE m.custno = m2.custno AND price IS NOT NULL;

SELECT 
    s.shopno AS 할인점코드,  -- 점포번호
    s.shopname AS 점포명,    -- 점포명
    LPAD(SUBSTR(o.orderno, 1, 4), 4, '0') || '-' || LPAD(SUBSTR(o.orderno, 5), 4, '0') AS 주문번호,   -- 주문번호 (형식: 0000-0001)
    TO_CHAR(TO_DATE(o.orderdate, 'YYYYMMDD'), 'YYYY-MM-DD') AS 주문일자,  -- 주문일자 (형식: yyyy-mm-dd)
    p.pcode AS 제품코드,     -- 제품코드
    p.pname AS 제품명,       -- 제품명
    o.amount AS 주문수량,    -- 주문수량
    TO_CHAR(p.cost, '9,999,999') AS 단가,  -- 소비자가격 (형식: 999,999)
    TO_CHAR(p.cost * o.amount, '9,999,999') AS 소비자가격,  -- 소비자가격
    TO_CHAR(p.cost * o.amount - (p.cost* o.amount * s.discount / 100), '9,999,999') AS 할인가격  -- 할인가격 (형식: 999,999)
FROM 
    tbl_order_202101 o
JOIN 
    tbl_product_202101 p ON o.pcode = p.pcode       -- 제품 테이블과 JOIN
JOIN 
    tbl_shop_202101 s ON o.shopno = s.shopno
    ORDER BY 주문일자;       -- 점포 테이블과 JOIN
    

SELECT s.shopno AS 할인점코드, p.pcode AS 제품코드, p.pname AS 제품명, SUM(o.amount) AS 주문총수량 
FROM tbl_shop_202101 s
JOIN  tbl_order_202101 o ON s.shopno = o.shopno
JOIN  tbl_product_202101 p ON o.pcode = p.pcode 
GROUP BY s.shopno, p.pcode, p.pname
ORDER BY s.shopno; 



SELECT pcode AS 제품코드, pname AS 제품명, cost AS 단가, 
TO_CHAR(cost - (cost*0.1) , '9,999,999') AS 할인10, 
TO_CHAR(cost - (cost * 0.15), '9,999,999') AS 할인15
FROM tbl_product_202101
ORDER BY pcode;