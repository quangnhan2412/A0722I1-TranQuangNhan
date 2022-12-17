drop database if exists QuanLySinhVien;
create database QuanLySinhVien;
use QuanLySinhVien;

create table Class(
ClassID int not null auto_increment	primary key,
ClassName varchar(60) not null,
StartDate datetime not null,
Status bit
);

create table Student(
StudentId int not null auto_increment	primary key,
StudentName varchar (30),
Address varchar (50),
Phone  varchar (20),
`Status` bit ,
ClassId int not null,
foreign key(classId) references Class (ClassID)
);

create table `Subject`(
SubId int not null auto_increment primary key,
SubName varchar(30) not null,
Credit TINYINT NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
`Status`  bit default 1
);
create table Mark(
MarkId int not null auto_increment primary key,
SubId int not null,
Mark float default 1,
unique (subId,StudentId),
foreign key(SubId) references Subject(SubId),
foreign key(StudentId) references StudentId);


 