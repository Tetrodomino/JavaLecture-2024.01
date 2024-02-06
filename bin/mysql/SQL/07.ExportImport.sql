################################
#
# 테이블 Export / Import
#
################################

/*
    1. secure_file_priv 확인
*/
SHOW VARIABLES LIKE 'secure_file_priv'; --C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\  (MySQL의 위치)


/*
    2. Export
    - 테이블의 내용을 파일로 옮기기 (Table → File)
*/
SELECT * FROM song INTO OUTFILE
    'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/song.csv'
    FIELDS TERMINATED BY ',' -- , 로 데이터를 구분짓기
    ENCLOSED BY '"' -- "" 로 데이터를 묶기
    LINES TERMINATED BY '\n'; -- 한 줄의 끝에 줄바꿈을 해주기

/*
    3. Import
    - 파일의 데이터를 테이블로 옮기기 (File → Table)
*/
# 데이터 삭제
truncate song;

# 데이터 로드
LOAD DATA INFILE
    'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/song.csv'
    INTO TABLE song
    FIELDS TERMINATED BY ',' -- 로드할 땐 데이터를 구분짓는 기준을 결정함
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n';

