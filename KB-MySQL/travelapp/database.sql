drop table if exists tbl_travel;

create table tbl_travel
(
    no          int auto_increment  not null primary key,
    district    varchar(50)         not null,
    title       varchar(512)        not null,
    description text,
    address     varchar(512),
    phone       varchar(256)
);

drop table if exists tbl_travel_image;
create table tbl_travel_image
(
    no        int auto_increment not null primary key,
    filename  varchar(512)       not null,
    travel_no int,
    constraint foreign key (travel_no) references tbl_travel (no) on delete cascade

);

select *
from tbl_travel;

select count(*)
from tbl_travel_image;

select *
from tbl_travel_image;

drop table if exists tbl_restaurant;
create table tbl_restaurant
(
    id          int auto_increment not null primary key,
    name        varchar(100),
    category    varchar(100),
    address     varchar(255),
    description text
);

select * from tbl_restaurant_review;

CREATE TABLE tbl_restaurant_review (
                                       no INT AUTO_INCREMENT PRIMARY KEY,
                                       restaurant_id INT,
                                       writer VARCHAR(100),
                                       content TEXT,
                                       score INT,
                                       FOREIGN KEY (restaurant_id) REFERENCES tbl_restaurant(id) ON DELETE CASCADE
);