create database BookReview;
use BookReview;

create table Book(
	bid int primary key,
    bname varchar(30),
    price int not null,
    publisher varchar(20)
    );
    
create table Review(
	bid int not null unique,
    bname varchar(30),
    remarks varchar(30),
    rating int,
    foreign key(bid) references Book(bid)
);
    
create table User(
	bid int not null unique,
    bname varchar(30),
    username varchar(20),
    foreign key(bid) references Book(bid)
);    
    
drop table Book;
drop table Review;
drop table User;

select * from Book;
select * from Book where price < 500;
 

select * from Review;
select * from Review where rating >= 4;


select * from User;