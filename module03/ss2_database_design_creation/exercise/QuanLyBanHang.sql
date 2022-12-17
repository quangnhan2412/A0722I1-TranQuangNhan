drop database if exists QuanLyBanHang ;
create database QuanLyBanHang ;
use QuanLyBanHang ;

create table Customer(
cID int not null primary key,
cName varchar(50) ,
cAge varchar(20)
);
create table Oder(
oID int not null primary key,
oDate datetime ,
oTotalPrice varchar(20),
cID int not null,
foreign key (cID) references Customer(cID)
);

create table Product(
pID int not null primary key,
pName varchar(50) ,
pPrice varchar(20)
);
create table OrderDetail(
odQTY varchar (20),
oID int,
pID int,
foreign key (oID) references Oder(oID),
foreign key (pID) references Product(pID)
);
