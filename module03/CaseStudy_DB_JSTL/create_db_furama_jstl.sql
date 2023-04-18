drop database if exists Furama_jstl;
create database Furama_jstl;
use Furama_jstl;

create table `position`(
`position_id` 	int 	not null primary key auto_increment,
`position_name`	varchar(45)
);

create table `education_degree`(
`education_degree_id` 	int 	not null primary key auto_increment,
`education_degree_name`	varchar(45)
);

create table `division`(
`division_id` 		int 	not null primary key auto_increment,
`division_name`	varchar(45)
);

create table `role`(
`role_id` 	int 	not null primary key auto_increment,
`role_name`	varchar(255)
);

create table `user`(
`username` 	varchar(255) not null primary key,
`password`	varchar(255)
);

create table `user_role`(
`role_id` 	int ,
`username` 	varchar(255),
foreign key(`role_id`)			 	references`role`(`role_id`) 					on delete cascade,
foreign key(`username`)		 		references`user`(`username`) 					on delete cascade
);

create table `employee`(
`employee_id` 			int 	not null primary key auto_increment,
`employee_name`			varchar(45),
`employee_birthday`		date,
`employee_id_card`		varchar(45),
`employee_salary`		double,
`employee_phone`		varchar(45),
`employee_mail`			varchar(45),
`employee_address`		varchar(45),
`position_id` 			int 	,
`education_degree_id` 	int 	,
`division_id` 			int		,
`username` 				varchar(255),
	foreign key(`position_id`)			 	references`position`(`position_id`) 					on delete cascade,
	foreign key(`education_degree_id`)		references `education_degree`(`education_degree_id`)	on delete cascade,
	foreign key(`division_id`)				references `division`(`division_id`)					on delete cascade,
	foreign key(`username`)					references `user`(`username`)							on delete cascade
);

create table `customer_type`(
`customer_type_id` 	int 	not null primary key auto_increment,
`customer_type_name` 	varchar(45)
);

insert into `customer_type`(`customer_type_id`,`customer_type_name`)
values(1,'vip'),
(2,'cui');

create table `customer`(
`customer_id` 		int 	not null primary key auto_increment,
`customer_type_id` 	int,
`customer_name` 	varchar(45),
`customer_birthday` date,
`customer_gender` 	bit(1),
`customer_id_card` 	varchar(45),
`customer_phone` 	varchar(45),
`customer_email` 	varchar(45),
`customer_adress` 	varchar(45),
foreign key(`customer_type_id`)		references`customer_type`(`customer_type_id`) on delete cascade
);

insert into customer(`customer_id`,`customer_type_id`,`customer_name`,`customer_birthday`,`customer_gender`,`customer_id_card`,`customer_phone`,`customer_email`,`customer_adress`)
values(3,1,'Nguyễn Thị Hào','1970-11-07',1,'643431213','077736452','tranquangnhan24122000@gmail.com','DN'),
		(4,1,'Trương Đình Nghệ','1984-10-07',1,'4545454545','0777472452','nguyenthib@gmail.com','HN'),
		(5,1,'Trương Đình Hào','1984-09-07',1,'2312323122','0777472452','nguyenthib@gmail.com','HN'),
		(6,1,'Trương Đình Nghệ','1985-08-07',1,'4545454545','0777472452','nguyenthib@gmail.com','HN'),
		(7,1,'Trương Đình Nguyễn','1985-11-07',1,'1234567890','0777472452','nguyenthib@gmail.com','HN'),
		(8,1,'Trương Thị Nghệ','1985-07-07',1,'1221131232','0777472452','nguyenthib@gmail.com','HN'),
		(9,1,'Trương Đình Nghệ','1986-06-07',1,'1312312313','0777472452','nguyenthib@gmail.com','HN'),
		(10,1,'Trương Đình Nghệ','1986-02-07',1,'3453476741','0777472452','nguyenthib@gmail.com','HN'),
		(12,1,'Trương Đình Nghệ','1985-01-07',1,'4542254545','0777472452','nguyenthib@gmail.com','HN');
        
        SET SQL_SAFE_UPDATES = 0;
delete from customer where customer_name = 'Trương Đình Nghệ';

select * from customer where customer_name like '%h%';


create table `service_type`(
`service_type_id` 	int 	not null primary key auto_increment,
`service_type_name` 	varchar(45)
);

create table `rent_type`(
`rent_type_id` 		int 	not null primary key auto_increment,
`rent_type_name` 	varchar(45),
`rent_type_cost` 	double
);

create table `service`(
`service_id` 			int 	not null primary key auto_increment,
`service_name` 			varchar(45),
`service_area` 			int,
`service_cost` 			double,
`service_max_people` 	int,
`rent_type_id` 			int,
`service_type_id` 		int,
`standard_room` 		varchar(45),
`description_other_convenience` varchar(45),
`pool_area` 			double,
`number_of_floors` 		int,
	foreign key(`rent_type_id`)			 references`rent_type`(`rent_type_id`) 			on delete cascade,
	foreign key(`service_type_id`)		references `service_type`(`service_type_id`)	on delete cascade
);


create table `contract`(
`contract_id` 		int 	not null primary key auto_increment,
`contract_start_date` 		datetime,
`contract_end_date` 		datetime,
`contract_deposit` 			double,
`contract_total_money` 		double,
`employee_id` 			int,
`customer_id` 			int,
`service_id` 			int,
	foreign key(`employee_id`)			 references`employee`(`employee_id`) 			on delete cascade,
	foreign key(`customer_id`)			 references`customer`(`customer_id`) 			on delete cascade,
	foreign key(`service_id`)		references `service`(`service_id`)	on delete cascade

);


create table `attach_service`(
`attach_service_id` 		int 	not null primary key auto_increment,
`attach_service_name` 		varchar(45),
`attach_service_cost` 		double,
`attach_service_unit` 		int,
`attach_service_status` 		varchar(45)
);

create table `contract_detail`(
`contract_detail_id` 	int 	not null primary key auto_increment,
`contract_id` 			int,
`attach_service_id` 	int,
`quantity` 				int,
	foreign key(`contract_id`)			 references`contract`(`contract_id`) 			on delete cascade,
	foreign key(`attach_service_id`)		references `attach_service`(`attach_service_id`)	on delete cascade
);

DELIMITER //
create procedure search_customer_by_name(search varchar(45))
begin
select * from customer
where customer_name like CONCAT('%', search, '%');
end //
DELIMITER ;

call search_customer_by_name("h");

















