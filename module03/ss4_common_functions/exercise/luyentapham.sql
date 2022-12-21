use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject` 
where Credit = (Select max(Credit) From `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from `subject`  join `mark`
using(SubId)
order by Mark DESC
Limit 1;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select S.StudentID, S.StudentName, S.Address, S.Phone, S.`Status`, AVG(Mark) as `dtb`
from student S join Mark M 
using (StudentId)
group by S.StudentId
order by  AVG(Mark) desc;

























