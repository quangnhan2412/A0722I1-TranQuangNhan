import {Injectable} from '@angular/core';
import {ICategory} from '../model/i-category';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private API = 'http://localhost:3000/category';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<ICategory[]> {
    return this.httpClient.get<ICategory[]>(this.API);
  }

  findById(id: number): Observable<ICategory> {
    return this.httpClient.get<ICategory>(this.API + '/' + id);
  }
}
