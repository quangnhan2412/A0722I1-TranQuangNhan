import {Component, Input, OnInit} from '@angular/core';
import {Student} from '../../../model/student';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-student-list-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input() student: Student;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = param.get('id');
      // Sử dụng service gọi findById => update cho student-list
    });
  }

}
