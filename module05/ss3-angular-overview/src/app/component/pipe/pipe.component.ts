import {Component, OnInit} from '@angular/core';
import {Student} from '../../model/student';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent implements OnInit {
  name = 'NguyỄn VăN A';
  date = new Date();
  number = '1000000';
  student: Student = {
    id: 1,
    name: 'Nguyễn Văn A',
    score: 9
  };
  date2 = '10-30-2000';

  constructor() {
  }

  ngOnInit(): void {
  }

}
