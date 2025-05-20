-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl1을 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
USE sqldb;
CREATE TABLE tbl1 (
	a INT PRIMARY KEY,
    b INT,
	c INT
);

SELECT * FROM tbl1;
SHOW INDEX FROM tbl1; -- 인덱스 조회

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl2를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl2 (
	a INT PRIMARY KEY,
    b INT UNIQUE,
    c INT UNIQUE,
    d int
);

SHOW INDEX FROM tbl2;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl3을 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl3 (
	a INT UNIQUE,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl3;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl4 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl4 (
	a INT UNIQUE NOT NULL,
	b INT UNIQUE,
    c INT UNIQUE,
    d INT
);

SHOW INDEX FROM tbl4;

-- sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl5를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
CREATE TABLE tbl5 (
	a INT UNIQUE NOT NULL, -- unique + not null -> 클러스터형 인덱스
	b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY -- unique + not null과 pk 둘 다 있다면, pk가 클러스터형 인덱스
);

SHOW INDEX FROM tbl5;

-- testdb에 다음 컬럼 목록을 가지는 usertbl을 만드세요.
CREATE DATABASE IF NOT EXISTS testdb;

USE testdb;

DROP TABLE IF EXISTS usertbl;

CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('kKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');

SELECT * FROM usertbl;

-- ALTER를 사용하여 usertbl에서 PRIMARY KEY 제약조건을 제거
ALTER TABLE usertbl DROP PRIMARY KEY;

-- name 컬럼을 새로운 기본키로 설정
ALTER TABLE usertbl ADD CONSTRAINT pk_name PRIMARY KEY(name);

SELECT * FROM usertbl;
SHOW INDEX FROM usertbl;