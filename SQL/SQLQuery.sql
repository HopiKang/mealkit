use MealKit

select * from Users

select * from member_table

select @@VERSION
select @@SERVERNAME

create table member_table(
	id int not null,
	member_email varchar(20) unique not null,
	member_password varchar(20) not null,
	member_name nvarchar(10) not null,
	primary key (id)
)

insert into #member_table(id, member_email, member_password, member_name) 
values (15321, ghwls, ghwls, 215)