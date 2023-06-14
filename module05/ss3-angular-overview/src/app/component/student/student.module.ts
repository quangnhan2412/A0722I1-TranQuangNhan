import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import {StudentComponent} from './student-list/student.component';
import {PipeComponent} from '../pipe/pipe.component';
import {LikeComponent} from '../like/like.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentCreateComponent} from './student-create/student-create.component';
import {StudentCreate2Component} from './student-create2/student-create2.component';
import { AbcComponent } from './abc/abc.component';
import {AppModule} from '../../app.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    StudentComponent,
    StudentDetailComponent,
    StudentCreateComponent,
    StudentCreate2Component,
    AbcComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ]
})
export class StudentModule { }
