import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../../../model/student';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {StudentService} from '../../../service/student.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-student-list-create2',
  templateUrl: './student-create2.component.html',
  styleUrls: ['./student-create2.component.css']
})
export class StudentCreate2Component implements OnInit {
  @Output() onCreate = new EventEmitter<Student>();
  student: Student;
  rfStudent: FormGroup;

  constructor(private router: Router, private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.rfStudent = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(10), Validators.pattern('^[^0-9]+$')]),
      score: new FormControl('', [Validators.required, this.checkScore]),
      password: new FormControl(''),
      confirmPassword: new FormControl('')
    });
  }

  addStudent() {
    // debugger
    // this.student-list = this.rfStudent.value;
    this.studentService.save(this.rfStudent.value).subscribe();
    // this.onCreate.emit(this.student-list);

    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Your work has been saved',
      showConfirmButton: false,
      timer: 1500
    });
    this.router.navigateByUrl('/student');
  }

  checkScore(control: AbstractControl): ValidationErrors | null {
    const score = +control.value;
    if (score < 0 || score > 10) {
      return {invalidScore: true};
    }
    return null;
  }
}
