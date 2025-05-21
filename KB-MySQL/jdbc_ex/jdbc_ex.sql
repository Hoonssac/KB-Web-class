create table users
(
    id       varchar(12) not null primary key,
    password varchar(12) not null,
    name     varchar(30) not null,
    role     varchar(5)  not null
);

insert into users(id, password, name, role)
values ('guest', 'guest123', '방문자', 'user');

insert into users(id, password, name, role)
values ('admin', 'admin123', '관리자', 'admin');

insert into users(id, password, name, role)
values ('member', 'member123', '일반회원', 'user');



select *
from users;

CREATE TABLE customer
(
    id   VARCHAR(10) PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE sushi_log
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(10),
    plate_color VARCHAR(10),
    eaten_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

select *
from customer;
select *
from sushi_log;