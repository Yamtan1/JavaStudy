CREATE TABLE exam(
id VARCHAR2(50),
phone VARCHAR2(50) PRIMARY KEY);

CREATE TABLE exam_result (
    id VARCHAR(255),
    phone VARCHAR(255) PRIMARY KEY,
    q1 VARCHAR2(50),
    q2 VARCHAR2(50),
    q3 VARCHAR2(50),
    q4 VARCHAR2(50),
    q5 VARCHAR2(50),
    correct_q1 VARCHAR2(50),  -- 정답 정보 추가
    correct_q2 VARCHAR2(50),  -- 정답 정보 추가
    correct_q3 VARCHAR2(50),  -- 정답 정보 추가
    correct_q4 VARCHAR2(50),  -- 정답 정보 추가
    correct_q5 VARCHAR2(50)  -- 정답 정보 추가
);

DROP TABLE exam_result;

commit;