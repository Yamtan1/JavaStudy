CREATE TABLE th_member(
id VARCHAR2(50) PRIMARY KEY,
pw VARCHAR2(50),
name VARCHAR2(50),
phone VARCHAR2(50),
grade VARCHAR2(20));

CREATE TABLE th_board(
title VARCHAR2(100),
content VARCHAR2(1000),
write VARCHAR2(50),
regdate DATE);

DROP TABLE th_member;

CREATE TABLE th_event(
id VARCHAR2(50)
);