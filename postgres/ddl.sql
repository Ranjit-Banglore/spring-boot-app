CREATE SCHEMA greenfield;

 CREATE TABLE greenfield.project(
	   id int primary key,
	   type text,
     cost int,
     scale text,
     location text,
     startDate date,
     endDate date,
     isApproved boolean
);

insert into greenfield.project values (1, 'commercial', 100, 'CR', 'CENTRAL',
to_date('2018-01-01','YYYY-MM-DD'),to_date('2021-01-01','YYYY-MM-DD'), true);

