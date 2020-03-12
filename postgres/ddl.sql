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

//Query to find out deals filtered by holidaycheck.de
select * from greenfield.product
where id in (select p.id
FROM greenfield.product p
INNER JOIN greenfield.holiday_check hc
ON trim(p.product_name)=trim(hc.name)
where p.product_type='pauschal'
and p.description  like '%'||trim(hc.land)||'%'
and p.description like '%'||trim(hc.stadt)||'%')
order by description;

select count(*) from greenfield.product p

