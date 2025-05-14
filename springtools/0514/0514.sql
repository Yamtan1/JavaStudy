CREATE TABLE th_qna(
id VARCHAR2(50),
qtitle VARCHAR2(200),
qcontent VARCHAR2(50),
qdate date,
answer VARCHAR2(1000));

CREATE TABLE th_review(
id VARCHAR2(50),
content VARCHAR2(1000),
regdate date);

DROP TABLE th_review;