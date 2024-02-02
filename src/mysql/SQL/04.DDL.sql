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