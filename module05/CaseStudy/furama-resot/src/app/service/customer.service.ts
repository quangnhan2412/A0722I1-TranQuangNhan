import {Injectable} from '@angular/core';
import {Customer} from '../model/Customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API = 'http://localhost:3000/customers';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API);
  }

  search(keyword: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API + '?q=' + keyword);
  }

  searchDate(start: string, end: string): Observable<Customer[]> {
    let key = '';
    if (start !== '' && end !== '') {
      key += '?dayOfBirth_gte=' + start + '&end_lte=' + end;
    } else if (start !== '') {
      key += '?dayOfBirth_gte=' + start;
    } else if (end !== '') {
      key += '?end_lte' + end;
    }
    return this.httpClient.get<Customer[]>(this.API + key);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API, customer);
  }

  findById(id: string): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API + '/' + id);
  }

  updateCustomer(id: string, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.API + '/' + id, customer);
  }

  deleteCustomer(id: string): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API + '/' + id);
  }
}
