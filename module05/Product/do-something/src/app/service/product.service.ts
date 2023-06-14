import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IProduct} from '../model/i-product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<IProduct[]> {
    return this.httpClient.get<IProduct[]>(this.API);
  }

  search(keyword: string): Observable<IProduct[]> {
    return this.httpClient.get<IProduct[]>(this.API + '?q=' + keyword);
  }

  findById(id: number): Observable<IProduct> {
    return this.httpClient.get<IProduct>(this.API + '/' + id);
  }

  searchDate(dateFrom: string, DateTo: string): Observable<IProduct[]> {
    let key = '';
    if (dateFrom !== '' && DateTo !== '') {
      key += '?dayOfBirth_gte=' + dateFrom + '&end_lte=' + DateTo;
    } else if (dateFrom !== '') {
      key += '?dayOfBirth_gte=' + dateFrom;
    } else if (DateTo !== '') {
      key += '?end_lte' + DateTo;
    }
    return this.httpClient.get<IProduct[]>(this.API + key);
  }

  deleteProduct(id: number): Observable<IProduct> {
    return this.httpClient.delete<IProduct>(this.API + '/' + id);
  }

  saveProduct(product: IProduct): Observable<IProduct> {
    return this.httpClient.post<IProduct>(this.API, product);
  }

  updateProduct(id: number, product: IProduct): Observable<IProduct> {
    return this.httpClient.put<IProduct>(this.API + '/' + id, product);
  }
}
