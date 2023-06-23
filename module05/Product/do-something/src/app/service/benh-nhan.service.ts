import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {ICategory} from '../model/i-category';
import {HttpClient} from '@angular/common/http';
import {IBenhNhan} from '../model/i-benh-nhan';

@Injectable({
  providedIn: 'root'
})
export class BenhNhanService {
  private API = 'http://localhost:3000/IBenhNhan';

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<IBenhNhan[]> {
    return this.httpClient.get<IBenhNhan[]>(this.API);
  }

  findById(id: string): Observable<IBenhNhan> {
    return this.httpClient.get<IBenhNhan>(this.API + '/' + id);
  }
}
