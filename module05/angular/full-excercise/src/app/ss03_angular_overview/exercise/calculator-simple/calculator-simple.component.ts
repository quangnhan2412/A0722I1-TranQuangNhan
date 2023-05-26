import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator-simple',
  templateUrl: './calculator-simple.component.html',
  styleUrls: ['./calculator-simple.component.css']
})
export class CalculatorSimpleComponent implements OnInit {
  result = null;
  color = 'red';

  constructor() {
  }

  ngOnInit() {
  }

  sum(numberOne: string, numberTwo: string) {
    this.result = +numberOne + +numberTwo;
  }

  minus(numberOne: string, numberTwo: string) {
    this.result = +numberOne - +numberTwo;
  }

  multiply(numberOne: string, numberTwo: string) {
    this.result = +numberOne * +numberTwo;
  }

  divide(numberOne: string, numberTwo: string) {
    this.result = +numberOne / +numberTwo;
  }
}
