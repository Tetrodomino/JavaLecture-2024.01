############################################
#
# 데이터 정의 언어(DML: Data Definition Language)
#
############################################

/*
    1. 테이블 생성
    addrBook이라는 Table 생성(ERMaster로 생성시킴)

    각 항목은 ID, 이름, 전화번호, 이메일, 생일
*/
CREATE TABLE addrBook
(
	aid int NOT NULL AUTO_INCREMENT,
	name varchar(16) NOT NULL,
	tel varchar(16),
	email varchar(32),
	birthday date,
	PRIMARY KEY (aid)
);

# 사용자 테이블 생성
CREATE TABLE users
(
	uid varchar(12) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(16) NOT NULL,
	email varchar(32),
	-- 등록일자
	regDate date DEFAULT (CURRENT_DATE) COMMENT '등록일자',
	isDeleted int DEFAULT 0,
	PRIMARY KEY (uid)
);

/*
    2. 테이블 조회
*/
# 데이터베이스내의 테이블 목록
SHOW TABLES;

# 테이블 구조
DESC 테이블명;


/*
    3. 테이블 삭제
*/
DROP VIEW 테이블 뷰명;
DROP TABLE 테이블명;

# dateTable 삭제
DROP TABLE dateTable;

# kcity 내의 모든 데이터 삭제
truncate kcity;


/*
    4. 테이블 이름 변경
*/
RENAME TABLE 기존테이블명 TO 새 테이블명;

# kcity를 korcity로 변경
RENAME TABLE kcity TO korcity;


/*
    5. 테이블 구조 변경
*/
# users 테이블에서 email 뒤에 tel 추가
ALTER TABLE users
    ADD tel VARCHAR(16) NOT NULL AFTER email; --tel의 자료형은 varchar이고 비울 수 없음(not null)

# users 테이블에서 tel의 not null 제거
ALTER TABLE users
    CHANGE tel tel VARCHAR(16); -- tel을 varchar(16)만 가진 tel로 변경