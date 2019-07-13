use social_db;

create table if not exists contact (
id int primary key not null auto_increment,
full_name varchar(255) not null,
phonenumber varchar(10)  unique null,
gender varchar(10),
email  varchar(255) unique, 
dob date,
location varchar(255),
address varchar(255),
events_of_celebration varchar(255)
 );
create table contact_group (
group_id int not null auto_increment,
id int,
group_name varchar(255) not null unique,
group_description varchar(255),
primary key(group_id),
foreign key(id) references contact(id)
);
create table circles(
circle_id int not null auto_increment,
circle_name varchar(255),
frequency int,
id int,
primary key(circle_id),
foreign key (id) references contact(id)
);