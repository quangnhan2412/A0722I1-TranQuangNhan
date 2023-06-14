import {Component, OnInit} from '@angular/core';
import {Student} from '../../../model/student';
import {StudentService} from '../../../service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  p: number = 1;
  students: Student[];

  isShow = true;
  like = 100;
  studentDetail: Student;

  constructor(private studentService: StudentService) {
  }

  ngOnInit(): void {
    // this.students = this.studentService.findAll();
    this.studentService.findAll().subscribe(next => {
      this.students = next;
    });
  }

  changeData(student: Student) {
    this.studentDetail = student;
  }

  createStudent(student: Student) {
    // this.students.push({...student-list, like: 0});
    this.studentService.save({...student, like: 0});
  }
}
