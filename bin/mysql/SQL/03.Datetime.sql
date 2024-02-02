####################
# 날짜 시간 조작
####################

/*
    1. 테이블 생성
*/
# 현재 시간을 저장하는 테이블 생성
CREATE TABLE if NOT EXISTS dateTable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    regDate DATE DEFAULT (CURRENT_DATE), /* 현재 날짜를 상징하는 CURRENT_DATE*/
    modTime DATETIME DEFAULT CURRENT_TIMESTAMP /* 현재 날짜와 시간을 나타내는 CURRENT_TIMESTAMP */
);


/*
    2. 데이터 입력
*/
# 기본값으로만 입력
INSERT INTO dateTable VALUES (default, default, default);

# 기본값으로만 입력2
INSERT INTO datetable(id) VALUES (DEFAULT);

# 값을 지정해서 입력
INSERT INTO dateTable(regDate, modTime) VALUES
    ('2024-01-01', '2024-01-31 10:25:00'),
    ('2024-02-01', '2024-02-02 10:45:00');


/*
    3. 데이터 조회
*/
# YYYY-MM-DD 형식
SELECT regDate, DATE_FORMAT(modTime, '%Y-%m-%d') FROM dateTable; /* date_format 부분이 형식을 지정하는 부분 */

# HH:MM:SS AM/PM 형식
SELECT DATE_FORMAT(modTime, '%h:%i:%s %p') FROM dateTable; /* 순서대로  시:분:초 오전오후  를 의미 */

# YY-MM-DD HH:MM 형식 (24시간)
SELECT DATE_FORMAT(modTime, '%y-%m-%d %H:%i') FROM dateTable; /* 순서대로 연-월-일 시:분 */

# 날짜 조회 함수
SELECT NOW(), CURDATE(), CURTIME(); /* 순서대로 전체시간, 연월일만, 시간만 */


/*
    4. 데이터 수정
*/
UPDATE dateTable SET regDate=CURDATE() WHERE id=3; /* 3번의 regDate 데이터 바꾸기 */

/*
    5. 날짜 계산
*/
# 날짜 더하기/빼기
SELECT DATE_ADD(NOW(), INTERVAL 40 DAY);
SELECT DATE_SUB(CURDATE(), INTERVAL 3 MONTH);

# 특정 날짜가 며칠 남았는지 계산하기
SELECT TO_DAYS('2024-11-14') - TO_DAYS(CURDATE());

# 특정 날짜의 요일 계산 (1: 일요일, 7: 토요일)
SELECT DAYOFWEEK(regDate) FROM datetable;