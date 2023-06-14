import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from './student-list/student.component';
import {StudentCreate2Component} from './student-create2/student-create2.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';


const routes: Routes = [
  {path: '', component: StudentComponent},
  {path: 'create', component: StudentCreate2Component},
  {path: 'detail/:id', component: StudentDetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
