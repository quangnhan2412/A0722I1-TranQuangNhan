import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl} from '@angular/forms';

let _id = 1;

@Component({
  selector: 'app-angular-name-card2',
  templateUrl: './angular-name-card2.component.html',
  styleUrls: ['./angular-name-card2.component.css']
})
export class AngularNameCard2Component implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();

  // id = 1;


  constructor() {
  }

  ngOnInit() {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }
}
