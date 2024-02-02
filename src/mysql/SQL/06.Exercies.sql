# 1. 2009년에 데뷔한 걸그룹의 히트송
-- 걸그룹 이름, 데뷔일자, 히트송 제목
SELECT name, debut, hit_song_id FROM girl_group
    WHERE debut < '2010-01-01' AND debut > '2008-12-31'


# 2. 데뷔일자가 빠른 5개 그룹의 히트송
-- 걸그룹 이름, 데뷔일자, 히트송 제목
SELECT name, debut, hit_song_id FROM girl_group
    ORDER BY debut ASC
    LIMIT 5;

# 3. 대륙별로 국가숫자, GNP의 합, 평균 국가별 GNP
SELECT continent, count(*) conNum, SUM(GNP) GNP, ROUND(AVG(GNP)) avgGNP FROM country
    GROUP BY continent;


# 4. 아시아 대륙에서 인구가 가장 많은 도시 10개를 내림차순으로 정렬
SELECT r.continent, r.name countryname, l.name cityname, l.population population FROM city l
	JOIN country r
	ON l.countrycode=r.code
	WHERE r.continent='Asia'
	ORDER BY l.population desc
	LIMIT 10;

# 5. 전 세계에서 GNP가 가장 높은 10개 국가에서 사용하는 공식 언어
-- 국가명, GNP, 언어명
SELECT l.name, l.GNP, r.language FROM country l
    JOIN countrylanguage r
    WHERE l.code=r.countrycode AND r.IsOfficial='T'
    ORDER BY l.GNP DESC
    LIMIT 10;