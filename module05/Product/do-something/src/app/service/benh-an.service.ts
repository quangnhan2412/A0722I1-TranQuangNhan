import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IProduct} from '../model/i-product';
import {IBenhAn} from '../model/i-benh-an';

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {
  private API = 'http://localhost:3000/IBenhAn';

  constructor(private httpClient: HttpClient) {
  }
  getAll(): Observable<IBenhAn[]> {
    return this.httpClient.get<IBenhAn[]>(this.API);
  }

  findById(id: string): Observable<IBenhAn> {
    return this.httpClient.get<IBenhAn>(this.API + '/' + id);
  }

  updateBenhAn(id: string, benhAn: IBenhAn): Observable<IBenhAn> {
    return this.httpClient.put<IBenhAn>(this.API + '/' + id, benhAn);
  }
  deleteBenhAn(id: string): Observable<IBenhAn> {
    return this.httpClient.delete<IBenhAn>(this.API + '/' + id);
  }
}
