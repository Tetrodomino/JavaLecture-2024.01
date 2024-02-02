############################################
#
# 데이터 조작 언어(DML: Data Manipulation Language)
#
############################################


/*
    2. Update 
    테이블의 내용을 갱신

    ────────────────────────────────────────────────────────────
    UPDATE 테이블
        SET 필드명1=값1, 필드명2=값2 ...
        WHERE 조건;
    ────────────────────────────────────────────────────────────

    ※ 조건 : 프라미머리 키 = 값 방식
*/
# 2340번의 이름을 수원으로 바꾸고 인구를 120만으로 바꾸기
UPDATE kcity SET name='수원', population=1200000 WHERE id=2340;

# 2390보다 높은 번호의 도시의 인구를 10만 추가
UPDATE kcity SET population=population+100000 WHERE id>2390;


/*
    3. Insert
    테이블 안에 새로운 데이터 넣기

    ────────────────────────────────────────────────────────────
    INSERT INTO 테이블(필드명1, 필드명2, ...)
        VALUES (값1, 값2, ...)

    INSERT INTO 테이블 VALUES (모든 필드의 값) [, (모든 필드의 값)];
    ────────────────────────────────────────────────────────────
*/
# 경기도 화성시, 의정부시 추가
INSERT INTO kcity
    VALUES (default, '화성', 'KOR', 'Kyonggi', 900000), /* 순서대로 ID, Name, Countrycode, district, population*/
           (default, '의정부', 'KOR', 'Kyonggi', 200000);

# 강원도 속초 추가 
INSERT INTO  kcity(name, countrycode, district ) VALUES('속초', 'KOR', 'Kang-won');
/* default 값을 이용해서 일부 필드값은 설정하지 않고 추가 */

# 경기도 광주 추가 - auto_increment 속성이 설정되어 있어도 ID 값을 임의로 부여
INSERT INTO kcity VALUES (2600, '광주', 'KOR', 'Kyonggi', 300000); /* 2600번으로 들어감 */


/*
    4. Delete
    테이블 안의 데이터를 삭제

    ────────────────────────────────────────────────────────────
    DELETE FROM 테이블 WHERE 조건;
    ────────────────────────────────────────────────────────────

    ※ 조건은 primary key(ID 등)을 쓰는 것이 좋음
*/
# 아까 추가한 속초 삭제
DELETE FROM kcity WHERE ID=2403;