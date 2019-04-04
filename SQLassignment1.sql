
drop schema if exists assignment1;

create schema if not exists assignment1;

use assignment1;

CREATE TABLE student (
	id int primary key auto_increment,
    nume varchar(45),
    cnp bigint(13) unique,
    icn	int,
    address varchar(45),
    materii varchar(120),
    grupa int 
);

create table materie(
	id int primary key auto_increment,
    nume varchar(20)
);

create table exam(
	id int primary key auto_increment,
    numematerie varchar(45),
    numestudent varchar(45),
    nota int,
    dataexamen date
);

create table profesor(
	id int primary key auto_increment,
    nume varchar(45),
	cnp bigint(13) unique
);

insert into student(`nume`,`cnp`,`icn`,`address`,`materii`,`grupa`)
values('ana','1111111111111','111','Str 1','mate,geografie,info','30234'),
	('mihai','2222222222222','222','Str 2','mate','30233'),
	('vasile','3333333333333','333','Str 3','info','30232');

insert into materie(nume)
values('mate'),
('geografie'),
('info');

insert into profesor(nume,cnp)
values('profesor1','1234567891114'),
('profesor2','1234567891115');

insert into exam(numematerie,numestudent,nota,dataexamen)
values('info','ana','10','2019-04-03'),
('info','ana','10','2019-04-02'),
('mate','mihai','10','2019-04-01');


