-- DB 생성
CREATE DATABASE webdb;

-- user 생성
CREATE user 'webdb'@'localhost' identified by 'webdb';
-- 권한 부여
GRANT ALL privileges on webdb.* to 'webdb'@'localhost';
