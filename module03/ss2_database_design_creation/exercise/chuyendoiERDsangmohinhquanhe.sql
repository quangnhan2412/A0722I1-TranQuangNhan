drop database if exists chuyendoicsdl;
create database chuyendoicsdl;
use chuyendoicsdl;

create table PHIEUXUAT(
 `SoPx` int not null primary key,
 `NgayXuat` datetime
 );
 
 create table VATTU(
`MaVTU` int not null primary key,
`TenVTU` varchar(50) not null
);

create table phieu_xuat_vat_tu(
`DGXuat` varchar(50) not null,
`SLxuat` int not null,
SoPx int,
MaVTU int,
 foreign key(SoPx) references PHIEUXUAT(SoPx),
 foreign key(MaVTU) references VATTU(MaVTU)
 );

 create	table PHIEUNHAP(
 `SoPN` int not null,
 `NgayNhap` datetime not null
);
   create table vat_tu_phieu_nhap(
   `SoPx` int,
   `MaVTU` int,
  `DGNhap` varchar(50) not null,
  `SLNhap` varchar(50) not null,
  foreign key(SoPx) references PHIEUXUAT(SoPx),
  foreign key(MaVTU) references VATTU(MaVTU)
  );
 
  create	table NhaCC(
 MaNCC int primary key,
 TenNCC varchar(50) not null,
 DiaChi varchar(50) not null
 );
 create	table DonHang(
 SoDH int primary key,
 NgayDH datetime
);


create table SDT(
MaNCC int,
SDT varchar(20) not null,
foreign key(MaNCC) references NhaCC(MaNCC)
);

create table `chi_tiet_don_dat_hang`(
`MaVTU` int,
`SoDH` int,
`TenVTU` varchar(20),
`NgayDH` datetime,
FOREIGN KEY (MaVTU) REFERENCES VATTU(MaVTU),
FOREIGN KEY (SoDH) REFERENCES DonHang(SoDH)
);
 