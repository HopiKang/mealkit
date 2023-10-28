use MealKit

create table Users(
	id int identity(1,1),
	nickname nvarchar(30) not null,
	user_id nvarchar(10) not null,
	user_password nvarchar(10) not null,
	created_date date not null
	primary key(id), unique(nickname, user_id)
)

create table Article(
	id int,
	article_name nvarchar(30) not null,
	article_id nvarchar(10) not null,
	primary key(id), unique(article_name, article_id)
)

create table Basket(
	nickname nvarchar(30) not null,
	article_id nvarchar(10) not null
	primary key(nickname), unique(article_id)
)

create table Review_Comment(
	nickname nvarchar(30) not null,
	review_comment nvarchar(100) not null,
	review_date date not null
	primary key(nickname), unique(review_comment)
)

create table Contact(
	nickname nvarchar(30) not null,
	contact nvarchar(100) not null,
	contact_date date not null
	primary key(nickname), unique(contact)
)

create table Contact_Comment(
	nickname nvarchar(30) not null,
	contact_comment nvarchar(100) not null,
	contact_commtnt_date date not null
	primary key(nickname), unique(contact_comment)
)

select * from Users
select * from Article
select * from Basket
select * from Review_Comment
select * from Contact
select * from Contact_Comment

drop table Users,Article,Basket,Review_Comment,Contact,Contact_Comment

drop table Contact_Comment