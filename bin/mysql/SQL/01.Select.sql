############################################
#
# 데이터 조작 언어(DML: Data Manipulation Language)
#
############################################

SHOW DATABASES;
USE world;
SHOW TABLES;
DESC city;

/*
1. Select : 특정 데이터를 고르는 명령어

SELECT 필드명
    FROM 테이블명
    JOIN 테이블명
    ON 조인 조건
    WHERE 조회 조건
    HAVING 그룹 조건
    ORDER BY 필드명 순서
    LIMIT 숫자 OFFSET 숫자;
*/

SELECT * FROM city; /* city의 모든 데이터 가져오기 */
SELECT `name`, population FROM city LIMIT 10; /* name이랑 population만 추려서 최대 10개 가져오기
                                                원래 필드명을 보존하고 싶으면 `` 사용 */

/*
 * 1.1 조회 조건 WHERE
 */
SELECT * FROM city WHERE countrycode='KOR'; /* countrycode가 KOR(문자열)인 데이터만 가져오기*/
SELECT * FROM city WHERE population >= 9000000; /* population이 9000000 이상인 데이터 가져오기*/

SELECT * FROM city WHERE countrycode='KOR' and population >= 1000000;
/* KOR 이면서 population이 1000000 이상인 데이터 */

SELECT DISTINCT district FROM city WHERE countrycode='KOR';
/* countrycode가 KOR인 데이터 중 district만 중복된 값을 제외하고 가져오기 */


# 수도권 도시(서울, 인천, 경기) 만 출력시키는 법
SELECT * FROM city
    WHERE district='Seoul' or district='Inchon' or district='Kyonggi';

SELECT * FROM city
    WHERE district IN ('Seoul', 'Inchon', 'Kyonggi');


# 경기도에서 인구수가 홀수인 도시
SELECT * FROM city
    WHERE district='Kyonggi' and population % 2 = 1;

# 국내에서 인구수가 50만 ~ 100만인 도시
SELECT * FROM city
    WHERE countrycode='KOR' and population >= 500000 and population <= 1000000;

# 충청남북도의 도시
SELECT * FROM city
    WHERE district LIKE 'Chungchong%';   /* % - 임의의 문자 */

/* 
 * 2. 순서 OREDER - ASC(오름차순), DESC(내림차순)
 */
# 인구수가 900만 이상인 도시를 내림차순으로 표시
SELECT * FROM city WHERE population >= 9000000
    ORDER BY population DESC;

# 국내에서 인구수가 50만 ~ 100만 도시를 지역 오름차순, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR' and population between 500000 AND 1000000
    ORDER BY population DESC, district ASC;


/*
 * 1.3 갯수
 */
# 전세계 인구수 Top 10 도시
SELECT * FROM city ORDER BY population DESC LIMIT 10;

# 국내 인구수 Top 5 도시
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

# 국내 인구수 Top 11 ~ 20 도시
SELECT * FROM city WHERE countrycode='KOR'
    ORDER BY population DESC
    LIMIT 10 OFFSET 10; /* OFFSET 10 : 앞에서 10개를 건너뜀 */


/*
 * 1.4 함수
 */
# 현재 날짜와 시각
SELECT NOW();

# 국내 도시의 수 - 기록된 데이터의 수
SELECT count(*) FROM city WHERE countrycode='KOR';

# 최대 최소 - 국내 도시 중 인구수 최대, 최소 도시
SELECT MAX(population), MIN(population) FROM city WHERE countrycode='KOR';

# 국내 도시의 인구 평균
SELECT AVG(population) FROM city WHERE countrycode='KOR';
SELECT ROUND(AVG(population)) FROM city WHERE countrycode='KOR'; /* 소숫점을 지우고 싶으면 ROUND 사용 */

SELECT ROUND(AVG(population)) AS pop_avg FROM city WHERE countrycode='KOR'; /* 결과값 항목의 이름을 pop_avg로 변경 */
/* 위 문장에서 AS(Aliasing)는 생략도 가능 */


/*
 * 1.5 그룹핑 Grouping
 */
# 국내 광역시도별 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) AS pop_avg FROM city 
    WHERE countrycode='KOR'
    GROUP BY district       /* district를 기준으로 묶기 */
    ORDER BY pop_avg DESC;

# 도별(도시의 개수가 2개 이상) 인구수의 평균을 내림차순으로
SELECT district, ROUND(AVG(population)) AS pop_avg FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2    /* 항목이 2개 이상인 그룹 */
    ORDER BY pop_avg DESC;

# 도시의 개수가 많은 나라 Top 10
SELECT countrycode, count(*) numCity FROM city
    GROUP BY countrycode
    ORDER BY numCity DESC
    LIMIT 10;

# 경기도의 도시 이름
SELECT `name` FROM city WHERE district='kyonggi';
SELECT GROUP_CONCAT(`name`) cites FROM city WHERE district='kyonggi'; /* 항목 가로로 정렬 */

# 국내 광역시도 이름
SELECT DISTINCT district FROM city WHERE countrycode="KOR";
SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode='KOR';


/*
 * 1.6 그룹핑 조건
 */
# 도별(도시의 개수가 2개 이상) 인구수의 평균을 내림차순으로
SELECT district, ROUND(AVG(population)) AS pop_avg FROM city 
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING count(*) >= 2    /* 항목이 2개 이상인 그룹 */
    ORDER BY pop_avg DESC;

# 국내 도시의 갯수가 5개 이상인 도
SELECT district, count(*) numCity FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING numCity >= 5;

# 국내 도시의 갯수가 5개 이상인 도의 평균 도시 인구수를 내림차순으로
SELECT district, count(*) numCity, ROUND(AVG(population)) AS pop_avg FROM city
    WHERE countrycode='KOR'
    GROUP BY district
    HAVING numCity >= 5
    ORDER BY pop_avg DESC;

# 도시 갯수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode ,count(*) numCity, ROUND(AVG(population)) AS pop_avg FROM city
    GROUP BY countrycode
    HAVING numCity >= 100
    ORDER BY pop_avg DESC;


/*
    1.7 Join - 다른 테이블의 자료 끌어오기
*/
# 인구수가 800만보다 큰 도시의 국가명, 도시명, 인구수
SELECT country.Name, city.Name, city.population FROM city
    JOIN country ON city.countrycode=country.code
    WHERE city.population > 8000000;

SELECT r.Name countryName, l.Name cityName, l.population FROM city l
	INNER JOIN country r /* INNER 는 생략 가능 */
	ON l.countrycode=r.code
	WHERE l.population > 8000000;

# 양쪽 테이블에서 필드명이 고유한 필드는 테이블 이름 생략 가능(Continent) 
SELECT Continent, r.Name countryName, l.Name cityName, l.population FROM city l
	INNER JOIN country r
	ON l.countrycode=r.code
	WHERE l.population > 8000000;

# 아시아 대륙에서 인구수가 많은 도시 Top 10
SELECT r.continent, r.name countryname, l.name cityname, l.population population FROM city l
	JOIN country r
	ON l.countrycode=r.code
	WHERE r.continent='Asia'
	ORDER BY l.population desc
	LIMIT 10;

# 아시아 국가의 국가명과 공식언어
SELECT l.name, r.`Language` FROM country l
	JOIN countrylanguage r
	ON l.code=r.countrycode
	WHERE l.continent='Asia'
	AND r.isofficial='T';

# 3개의 테이블 조인
# 아시아 대륙에서 인구수가 가장 많은 10 도시에서 사용하는 공식 언어
