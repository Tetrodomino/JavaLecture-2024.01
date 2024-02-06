####################
# 테이블 조인(join)
####################

/*
    1. 테이블 생성
*/
# song Table
CREATE TABLE if NOT EXISTS song
(
    sid int primary key AUTO_INCREMENT,
    title varchar(32) NOT NULL,
    lyrics varchar(64)
) AUTO_INCREMENT = 101; --101번부터 시작한다는 것을 의미

# 걸그룹 테이블
CREATE TABLE if NOT EXISTS girl_group
(
    gid int primary key AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    debut date NOT NULL,
    hit_song_id int
) AUTO_INCREMENT=1001;


/*
    2. 데이터 입력
*/
# song Table에 데이터 입력
INSERT INTO song (title, lyrics) VALUES
    ('Tell Me', 'tell me tell me tetetete tel me'),
    ('Gee', 'GEE GEE GEE GEE GEE BABY BABY'),
    ('미스터', '이름이 뭐야 미스터'), 
    ('Abracadabra', '이러다 미쳐 내가 여리여리'),
    ('8282', 'Give me a call Baby baby'), ('기대해', '기대해'),
    ('I Dont care', '다른 여자들의 다리를'), 
    ('Bad Girl Good Girl', '앞에선 한 마디 말도'), ('피노키오', '뉴예삐오'),
    ('별빛달빛', '너는 내 별빛 내 마음의 별빛'), 
    ('A', 'A 워오우 워오우워 우우우'),
    ('나혼자', '나 혼자 밥을 먹고 나 혼자 영화 보고'), ('LUV', '설레이나요 '),
    ('짧은치마', '짧은 치마를 입고 내가 길을 걸으면'),
    ('위아래', '위 아래 위위 아래'), ('Dumb Dumb', '너 땜에 하루종일');

# girl_group 테이블
INSERT INTO girl_group (name, debut, hit_song_id) VALUES
    ('원더걸스', '2007-02-10', 101),
    ('소녀시대', '2007-08-02', 102), ('카라', '2009-07-30', 103),
    ('브라운아이드걸스', '2008-01-17', 104), ('다비치', '2009-02-27', 105),
    ('2NE1', '2009-07-08', 106), ('f(x)', '2011-04-20', 108),
    ('시크릿', '2011-01-06', 109), ('레인보우', '2010-08-12', 110),
    ('애프터 스쿨', '2009-11-25', 120), ('포미닛', '2009-08-28', 121);


/*
    3. Table Join
*/
# song의 곡 중 girl_group의 hit_song_id에 해당하는 것을 찾기 (INNER JOIN)
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	INNER JOIN girl_group r     --INNER는 생략이 가능
	ON l.sid=r.hit_song_id;

# Left outer join
-- from에 해당하는 song이 좌측이 되어 song과 girlgroup의 교집합(ON 조건에 맞는 데이터)을 출력하되
-- 교집합에 해당하지 않는 나머지 song 데이터의 name과 debut는 NULL로 처리해서 보여주는 방식 
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	LEFT OUTER JOIN girl_group r     --Outer는 생략 가능
	ON l.sid=r.hit_song_id;

# Right outer join
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	RIGHT OUTER JOIN girl_group r     --Outer는 생략 가능
	ON l.sid=r.hit_song_id;

# Full outer join
-- LEFT와 RIGHT의 합집합
-- mysql에서는 자체적으로는 지원하지 않으며 left와 right를 union 하여 만듦
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	LEFT OUTER JOIN girl_group r
	ON l.sid=r.hit_song_id;
UNION
SELECT r.name, r.debut, l.title, l.lyrics FROM song l
	RIGHT OUTER JOIN girl_group r
	ON l.sid=r.hit_song_id;