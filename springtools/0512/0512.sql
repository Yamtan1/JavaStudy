SELECT rownum, b.* FROM test_board b
WHERE rownum BETWEEN 1 and 10;
//검색결과를 나올때마다 순차적으로 번호를 부여함.(rownum) ,무조건 1번부터 시작해야함

SELECT * FROM
(SELECT rownum rn, b.*
FROM test_board b)
WHERE rn BETWEEN 11 AND 20;