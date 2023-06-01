import { Component, OnInit } from '@angular/core';
import {DateUtilService} from '../service/date-util.service';

@Component({
  selector: 'app-timelines-app',
  templateUrl: './timelines-app.component.html',
  styleUrls: ['./timelines-app.component.css']
})
export class TimelinesAppComponent implements OnInit {

  output = '';

  constructor(private dateUtilService: DateUtilService) {
  }

  ngOnInit() {
  }


  onChange(value: string) {
    this.output = this.dateUtilService.ffToNow(value)
  }
}
