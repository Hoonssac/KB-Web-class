-- sqldb에서 usertbl 테이블에서 다음 내용들을 확인하세요
USE sqldb;
SELECT * FROM usertbl;

SHOW INDEX FROM usertbl;
SHOW TABLE STATUS LIKE 'usertbl';

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr 이름으로 인덱스륾 만들고, 인덱스 목록을 확인하세요.
CREATE INDEX idx_usertbl_addr ON usertbl(addr);

SHOW INDEX FROM usertbl;

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고, 내용이 없다면 실제 적용되도록 한 후, 인덱스의 크기를 확인하세요.
SHOW TABLE STATUS LIKE 'usertbl';
ANALYZE TABLE usertbl; -- 생성한 인덱스를 실제 적용시킴
SHOW TABLE STATUS LIKE 'usertbl';

-- 출생년도(birthYear)에 보조 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_birthYear
ON usertbl(birthYear);

CREATE UNIQUE INDEX idx_usertbl_name
ON usertbl(name);

SHOW INDEX FROM usertbl;

-- 이름(name)에 보조 인덱스 삭제
DROP INDEX idx_usertbl_name ON usertbl;

-- name, birthYear 조합으로 인덱스 생성
CREATE UNIQUE INDEX idx_usertbl_name_birthYear
ON usertbl(name, birthYear);

SHOW INDEX FROM usertbl;

-- 인덱스 삭제
DROP INDEX idx_usertbl_addr ON usertbl;
DROP INDEX idx_usertbl_name_birthYear ON usertbl;

SHOW INDEX FROM usertbl;

-- 실습 데이터베이스 및 사용자를 생성하고, 해당 데이터베이스에 대해 모든 권한을 부여하세요.
CREATE DATABASE scoula_db;
DROP USER IF EXISTS scoula_db;
CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON scoula_db.* TO 'scoula'@'%';
FLUSH PRIVILEGES;










































