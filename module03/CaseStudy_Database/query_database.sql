use furama;
-- Task 2 : Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' ) and  char_length(ho_ten) <= 15;


-- Task 3 : Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (year(CURRENT_TIMESTAMP) - YEAR(ngay_sinh) BETWEEN 18 AND 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');

-- Task 4 : Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select kh.ma_khach_hang,
    kh.ho_ten,
    COUNT(hd.ma_khach_hang) as so_lan_dat_phong
from 
	khach_hang kh
		join 
	loai_khach lk 
	using (ma_loai_khach)
		join
	hop_dong hd
	using (ma_khach_hang)
where
	lk.ten_loai_khach = 'Diamond'
group by hd.ma_khach_hang
order by so_lan_dat_phong;
-- Task 5: Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang,
    kh.ho_ten,
    lk.ten_loai_khach,
    hd.ma_hop_dong,
    dv.ten_dich_vu,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    if (hdct.ma_hop_dong is null, dv.chi_phi_thue, (dv.chi_phi_thue + sum(hdct.so_luong * dvdk.gia ))) AS tong_tien			
from
	khach_hang kh
		join
	loai_khach lk
	using(ma_loai_khach)
		left join
	hop_dong hd
	using(ma_khach_hang)
		left join
	dich_vu dv
	using(ma_dich_vu)
		left join
    hop_dong_chi_tiet hdct
    using(ma_hop_dong)
		left join
	dich_vu_di_kem dvdk
    using(ma_dich_vu_di_kem)
    group by kh.ma_khach_hang, hd.ma_hop_dong
    order by kh.ma_khach_hang;

-- task 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của 
-- tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select  dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu 
from dich_vu dv
	join
	loai_dich_vu ldv
    using(ma_loai_dich_vu)
    join
    hop_dong hd 
    using(ma_dich_vu)
where dv.ma_dich_vu not in 
(select dv.ma_dich_vu 
from dich_vu dv 
	join
    hop_dong hd 
    using(ma_dich_vu)
    where 
    (quarter(hd.ngay_lam_hop_dong)=1) and
		year(hd.ngay_lam_hop_dong)='2021')
group by hd.ma_dich_vu;
    
-- task7 :	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
    
select 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
from
    dich_vu dv
        join
    loai_dich_vu ldv  using(ma_loai_dich_vu)
        right join 
    hop_dong hd using(ma_dich_vu)
where
    dv.ma_dich_vu in (select 
            dv.ma_dich_vu
        from
            dich_vu dv
                join
            hop_dong hd using(ma_dich_vu)
        where
            year(hd.ngay_lam_hop_dong) = '2020')
        and dv.ma_dich_vu not in (select 
            dv.ma_dich_vu
        from
            dich_vu dv
                join
            hop_dong hd using(ma_dich_vu)
        where
            year(hd.ngay_lam_hop_dong) = '2021')
group by ma_dich_vu;
-- task 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
select distinct ho_ten from khach_hang ;
select  ho_ten from khach_hang group by ho_ten;
select  ho_ten from khach_hang union select ho_ten from khach_hang;

-- task 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as `month` ,count(ma_khach_hang) as `so_luong_khach_hang`
from hop_dong hd
where  (year(hd.ngay_lam_hop_dong)='2021')
group by `month`
order by `month`;

-- task 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc,ifnull(sum(hdct.so_luong) ,0)as  so_luong_dich_vu_di_kem
from hop_dong hd
left join hop_dong_chi_tiet hdct
using(ma_hop_dong)
group by hd.ma_hop_dong
order by ma_hop_dong;

-- task 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng
--  có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from
    dich_vu_di_kem dvdk
        join
    hop_dong_chi_tiet hdct using(ma_dich_vu_di_kem)
        join
    hop_dong hd using(ma_hop_dong)
        join
    khach_hang kh using (ma_khach_hang)
        join
    loai_khach lk  using(ma_loai_khach)
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quảng Ngãi')
group by dvdk.ten_dich_vu_di_kem,dvdk.ma_dich_vu_di_kem
order by  dvdk.ma_dich_vu_di_kem;
-- task 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select 
    hd.ma_hop_dong,
    nv.ho_ten,
    kh.ho_ten,
    kh.so_dien_thoai,
    dv.ten_dich_vu,
    IFNULL(SUM(hdct.so_luong), 0) AS so_luong_dich_vu_di_kem,
    hd.tien_dat_coc
from
    hop_dong hd
       left join
    nhan_vien nv ON nv.ma_nhan_vien = hd.ma_nhan_vien
        left join
    khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
         left join
    dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
        left join
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
where
    dv.ma_dich_vu in (select 
            dv.ma_dich_vu
        from
            dich_vu dv
                join
            hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
       where
            hd.ngay_lam_hop_dong between '2020-10-01' and '2020-12-31')
        and dv.ma_dich_vu not in (select 
            dv.ma_dich_vu
        from
            dich_vu dv
                join
            hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
        where
            hd.ngay_lam_hop_dong between '2021-01-01' and '2021-06-30')
group by  hd.ma_hop_dong;
-- task 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select 
    dvdk.*, SUM(hdct.so_luong) AS so_luong_dich_vu_di_kem
from
    dich_vu_di_kem dvdk
        join
    hop_dong_chi_tiet hdct ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all (select 
        SUM(hdct.so_luong)
    from
        dich_vu_di_kem dvdk
            join
        hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
    group by dvdk.ma_dich_vu_di_kem);

-- task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
--  (được tính dựa trên việc count các ma_dich_vu_di_kem). 
select ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet
inner join dich_vu_di_kem using(ma_dich_vu_di_kem)
inner join hop_dong using(ma_hop_dong)
inner join dich_vu using(ma_dich_vu)
inner join loai_dich_vu using(ma_loai_dich_vu)
where hop_dong_chi_tiet.ma_dich_vu_di_kem in
(select ma_dich_vu_di_kem
from hop_dong_chi_tiet
group by ma_dich_vu_di_kem
having count(ma_dich_vu_di_kem) = 1)
group by hop_dong_chi_tiet.ma_hop_dong, hop_dong_chi_tiet.ma_hop_dong_chi_tiet;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới
--  chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021. 
select 
    nv.ma_nhan_vien,
    nv.ho_ten,
    td.ten_trinh_do,
    bp.ten_bo_phan,
    nv.so_dien_thoai,
    nv.dia_chi
from
    nhan_vien nv
        join
    bo_phan bp using(ma_bo_phan)
        join
    trinh_do td  using(ma_trinh_do)
        join
    hop_dong hd  using(ma_nhan_vien)
where hd.ngay_lam_hop_dong BETWEEN '2020-01-01' AND '2021-12-31'
group by hd.ma_nhan_vien
HAVING COUNT(hd.ma_nhan_vien) <= 3;  

-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
Delete from nhan_vien
where 
ma_nhan_vien not in (select
* from (select hd.ma_nhan_vien from nhan_vien nv
left join hop_dong hd using(ma_nhan_vien)
group by hd.ma_nhan_vien
having count(hd.ma_nhan_vien) >= 1) as xoa_nhan_vien);

SET SQL_SAFE_UPDATES = 0;

-- task 17 :Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

update khach_hang kh
set kh.ma_loai_khach = 1
where kh.ma_loai_khach = 2 and kh.ma_khach_hang in (select tong_tien.ma_khach_hang from 
	(select kh.ma_khach_hang,
		if (hdct.ma_hop_dong is null, dv.chi_phi_thue, (dv.chi_phi_thue + sum(hdct.so_luong * dvdk.gia ))) AS tong_tien 
		from khach_hang kh
        join loai_khach lk using(ma_loai_khach) 
        left join hop_dong hd using(ma_khach_hang)
		left join dich_vu dv using(ma_dich_vu)
		left join hop_dong_chi_tiet hdct using(ma_hop_dong)
		left join dich_vu_di_kem dvdk using(ma_dich_vu_di_kem)
	where year(hd.ngay_lam_hop_dong) = '2021'
    group by kh.ma_khach_hang, hd.ma_hop_dong
	having tong_tien > 10000000
    order by kh.ma_khach_hang) as tong_tien);
-- task 18 :	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
delete from khach_hang kh
where ma_khach_hang in
(select kh.ma_khach_hang from khach_hang kh left join hop_dong hd using(ma_khach_hang)
where year(hd.ngay_lam_hop_dong) < 2021 );
-- task 19:	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem dvdk
set gia = gia * 2 
where ten_dich_vu_di_kem = (select result.ten_dich_vu_di_kem from (select ma_dich_vu_di_kem,ten_dich_vu_di_kem
							from dich_vu_di_kem  
								join hop_dong_chi_tiet using(ma_dich_vu_di_kem)
								join 	hop_dong hd using(ma_hop_dong)
							where year(hd.ngay_lam_hop_dong) = 2020
							group by ma_dich_vu_di_kem
							having sum(so_luong) > 10) as result);
-- task 20 .	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.				
select
    nv.ma_nhan_vien as id,
    nv.ho_ten,
    nv.email,
    nv.so_dien_thoai,
    nv.ngay_sinh,
    nv.dia_chi
from
    nhan_vien nv 
union all select
    kh.ma_khach_hang as id,
    kh.ho_ten,
    kh.email,
    kh.so_dien_thoai,
    kh.ngay_sinh,
    kh.dia_chi
from
    khach_hang kh;
-- task 21 Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as
select * from nhan_vien nv 
where nv.dia_chi like '%Gia Lai%' and ma_nhan_vien in( select nv.ma_nhan_vien 
														from nhan_vien nv join hop_dong hd using(ma_nhan_vien)
                                                        where hd.ngay_lam_hop_dong = '2020-12-08'
                                                        group by nv.ma_nhan_vien
                                                        having count(hd.ma_nhan_vien) >=1);

-- task 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien
set dia_chi = 'Liên Chiểu'
where ho_ten = 'Hồ Thị Yến'; -- --> sẽ update không được vì bảng  v_nhan_vien dính truy vấn con trong where nên phải tạo view kh có truy vấn ở dưới để update

create view v1_nhan_vien AS select * from nhan_vien;
update  v1_nhan_vien 
set dia_chi = 'Liên Chiểu'
where ma_nhan_vien = 3 ;

-- task 23 Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
DELIMITER //
create procedure sp_xoa_khach_hang(in idMaKH int)
begin
delete from khach_hang
where ma_khach_hang = idMaKH;
end;
// DELIMITER ;
call sp_xoa_khach_hang(1)
-- task 24 	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
DELIMITER //
create procedure sp_them_moi_hop_dong ( 
in ngay_lam_hop_dong datetime ,
in ngay_ket_thuc datetime ,
in tien_dat_coc double ,
in ma_nhan_vien int ,
in ma_khach_hang int ,
in ma_dich_vu int)
begin
insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu);
end ;
// DELIMITER ;	
call sp_them_moi_hop_dong('2023-01-14','2024-01-18',99999999999,2,2,2);




