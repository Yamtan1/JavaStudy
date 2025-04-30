CREATE TABLE accounts(
    account_id VARCHAR2(10) PRIMARY KEY,
    owner_name VARCHAR2(50) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL);
    
-- 초기 데이터 삽입
INSERT INTO accounts VALUES ('A001', '김철수', 1000000);
INSERT INTO accounts VALUES ('A002', '이영희', 500000);

SELECT * FROM accounts;
commit;