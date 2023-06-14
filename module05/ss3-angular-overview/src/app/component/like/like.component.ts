import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent implements OnInit {
  @Input() like = 0;
  constructor() { }

  ngOnInit(): void {
  }

  addLike() {
    this.like++;
  }
}
