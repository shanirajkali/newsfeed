create table merchantProfile(merchant_id int primary key not null auto_increment,name varchar(30) not null,gender varchar(6) not null,email varchar(30) not null,phone numeric(10) not null,merchant_type varchar(20) not null,address_id int,foreign key(address_id) references address(address_id),address_line varchar(50),dob date,password varchar(20) not null,create_time_stamp datetime,update_time_stamp datetime,active_status boolean);
create table news(news_id int primary key not null auto_increment,heading varchar(100) not null,description varchar(400),news_type varchar(15),create_time datetime,update_time datetime,merchant_id int,foreign key(merchant_id) references merchantProfile(merchant_id));
create table image(images 
alter table news add column active_status int not null;
create table aboutNews(about_news_id int primary key not null auto_increment,like json,;
select DISTINCT state from address where country='india';
create table address(address_id int not null primary key auto_increment,country varchar(20),state varchar(20),district varchar(20),city varchar(20));
insert into address(country,state,district,city) values('india','uttar pradesh','muzaffarnagar','muzaffarnagar');
insert into merchantProfile(name,gender,email,phone,merchant_type,address_id,address_line,dob,password,create_time_stamp,update_time_stamp,active_status) values('shani rajkali','male','shanirajkali@gmail.com',9897028778,'technical',7,'','1994-10-04','1KALIhpdlink',now(),now(),1);
select * from address;
select * from merchantprofile;
select name from merchantprofile where merchant_id=29;
select * from news;
alter table address drop id;
select heading,create_time from news where create_time>='2017-03-14 14:35:46' and merchant_id=29 limit 10 ;
alter table address add column address_id varchar(15) primary key not null;
select heading,create_time from news where create_time<='undefined'  order by create_time desc limit 150 ;

select phone from merchantprofile where phone=9897028778;
select address_id from address where district='meerut' and city='mawana';
select name from merchantprofile where email="shanirajkali@gmail.com" AND password="1KALIhpdlink";
select heading from news where news_type='technical' or merchant_id=30;
select address.address_id,merchantprofile.merchant_id,merchantprofile.address_id  from address inner join merchantprofile on merchantprofile.address_id=address.address_id;
select address.country,address.state,address.district,address.city,merchantprofile.name,merchantprofile.address_id from merchantprofile right join  address on merchantprofile.address_id=address.address_id;
select news_type,count(news_id) from news where news_type='technical' or news_type='local' group by news_type;