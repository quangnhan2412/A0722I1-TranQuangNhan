drop database if exists demo;
	create database demo;
	use demo;

	create table users(
	`id` int(3) not null auto_increment,
	`name` varchar(120) not null,
	`email` varchar(220) not null,
	`country` varchar(120),
	primary key(id)
	);

	insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
	insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
    
    delimiter $$
    create procedure get_user_by_id(user_id int)
    begin
    select users.name,users.email,users.country
    from users
    where users.id = user_id;
    end $$
    delimiter ;
    
    delimiter $$
    create procedure insert_user(
    in user_name varchar(50),
    in user_email varchar(50),
    in user_country varchar(50))
    begin
    insert into users(name,email,country)value(user_name,user_email,user_country);
    end $$
    delimiter ;
    
    
create table Permision(
id int(11) primary key,
name varchar(50)
);

create table User_Permision(
permision_id int(11),
user_id int(11)
);
    
    
insert into Permision(id, name) values(1, 'add');
insert into Permision(id, name) values(2, 'edit');
insert into Permision(id, name) values(3, 'delete');
insert into Permision(id, name) values(4, 'view');
    
    
    -- chức năng hiển thị danh sách users
	delimiter $$
    create procedure view_all_users()
    begin select *
    from users;
    end $$
    delimiter ;
    
    call view_all_users();
    
    
    delimiter $$
create procedure update_user_store_procedure(
	IN user_id int,
    IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50)
)
	begin
		update users
		set name = user_name, email = user_email, country = user_country
		where id = user_id;
	end $$
delimiter ;
call update_user_store_procedure(3,"nhan","nhan","nhan"); 
delimiter $$
create procedure delete_user_store_procedure(
	IN user_id int
)
	begin
		delete from users 
        where id = user_id;
	end $$
delimiter ;
    
    
    
    
    