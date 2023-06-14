import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../../../model/student';

@Component({
  selector: 'app-student-list-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  @Output() onCreate = new EventEmitter<Student>();
  student: Student;

  constructor() {
  }

  ngOnInit(): void {
  }

  addStudent(name: string, score: string) {

    this.student = {
      name,
      score: +score
    };

    this.onCreate.emit(this.student);
  }
}
