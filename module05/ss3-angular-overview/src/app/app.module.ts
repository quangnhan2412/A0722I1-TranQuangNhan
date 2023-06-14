import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { StudyComponent } from './component/study/study.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { StudentComponent } from './component/student/student-list/student.component';
import { PipeComponent } from './component/pipe/pipe.component';
import { LikeComponent } from './component/like/like.component';
import { StudentDetailComponent } from './component/student/student-detail/student-detail.component';
import { StudentCreateComponent } from './component/student/student-create/student-create.component';
import {StudentCreate2Component} from './component/student/student-create2/student-create2.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    StudyComponent,
    PipeComponent,
    LikeComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  exports: [
    LikeComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
