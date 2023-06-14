import {Injectable} from '@angular/core';
import {Student} from '../model/student';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Student[]> {
    // return this.students;
    // const search = 'v';
    return this.httpClient.get<Student[]>('http://localhost:3000/students');
  }

  save(student: Student): Observable<Student> {
    // this.students.push(student-list);
    return this.httpClient.post<Student>('http://localhost:3000/students', student);
  }
}
