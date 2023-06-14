import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {StudentComponent} from './component/student/student-list/student.component';
import {StudentCreate2Component} from './component/student/student-create2/student-create2.component';
import {StudentDetailComponent} from './component/student/student-detail/student-detail.component';
import {StudentModule} from './component/student/student.module';


const routes: Routes = [
  // {path: 'student', component: StudentComponent},
  // {path: 'student-list/create', component: StudentCreate2Component},
  // {path: 'student-list/detail/:id', component: StudentDetailComponent},
  {
    path: 'student',
    loadChildren: () => import('./component/student/student.module').then(module => module.StudentModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
