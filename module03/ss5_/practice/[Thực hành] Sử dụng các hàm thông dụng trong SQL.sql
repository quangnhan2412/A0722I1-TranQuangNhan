use quanlysinhvien;
-- Bước 2: Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select 	Address,count(StudentID) as 'So luong sinh vien'
from student
group by Address;
-- Bước 3: Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
 select S.StudentId,S.StudentName,AVG(mark)
 from student S join mark M on S.StudentId = M.StudentId
 group by S.StudentId,S.StudentName;
 
-- Bước 4: Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
group by S.StudentId,S.StudentName
Having AVG(mark)>15;

-- Bước 5: Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);
