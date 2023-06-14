import {Injectable} from '@angular/core';
import {CustomerType} from '../model/CustomerType';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private API = 'http://localhost:3000/customerType';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.API);
  }

  findById(id: number): Observable<CustomerType> {
    return this.httpClient.get<CustomerType>(this.API + '/' + id);
  }
}
