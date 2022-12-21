use QuanLyBanHang ;
INSERT INTO customer (cID,cName,cAge)
VALUES (1, 'Minh Quan', 10),
       (2, 'Ngoc Oanh', 20),
       (3, 'Hong Ha', 10);

INSERT INTO `order` (oID ,oDate,oTotalPrice ,cID )
VALUES		(1, '2006-03-21',null,1),
			(2, '2006-03-23',null,2),
			(3, '2006-03-16',null,1);
  
INSERT INTO product (pID ,pName,pPrice )
VALUES		(1, 'May Giat',3),
			(2, 'Tu Lanh',5),
			(3, 'Dieu Hoa',7),
			(4, 'Quat',1),
			(5, 'Bep Dien',2);
            
INSERT INTO orderdetail (oID,pID,odQTY )
VALUES		(1,1 ,3),
			(1,3 ,7),
			(1, 4,2),
			(2,1 ,1),
			(3,1 ,8),
			(2,5 ,4),
			(2,3 ,3);
			
   --          
  -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
  select oID,oDate,oTotalPrice
  from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select distinct cName,pName
from customer
join `order` 
	using(cID)
join orderdetail
	using(oID)
join product
	using(pID);

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from customer left join `order`
using(cID)
where oID is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select distinct  oID,oDate,odQTY * pPrice as giatien
from `order`
join orderdetail 
using(oID)
join product
using (pID)