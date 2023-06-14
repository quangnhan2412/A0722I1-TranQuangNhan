import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-study',
  templateUrl: './study.component.html',
  styleUrls: ['./study.component.css']
})
export class StudyComponent implements OnInit {
  name = 'Nhân';
  link = 'https://www.facebook.com/';
  mau = 'yellow';
  result: number = undefined;
  color = 'red';

  constructor() {
  }

  ngOnInit(): void {
  }

  sum(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber + +secondNumber;
  }
}
