DESC tbl_member;
SELECT * FROM tbl_member WHERE id = 'bbb123';

CREATE TABLE test_member(
id VARCHAR2(50) PRIMARY KEY,
pw VARCHAR2(50),
name VARCHAR2(50),
phone VARCHAR2(50)
);

CREATE TABLE test_board(
title VARCHAR2(200),
content VARCHAR2(500),
write VARCHAR2(50),
regdate DATE);

SELECT COUNT(*) FROM test_member WHERE id = 'aaa123' AND pw = 'aaa123';
SELECT id, pw FROM test_member WHERE id = 'bbb123' AND pw = 'bbb123';
SELECT * FROM test_member;
commit;