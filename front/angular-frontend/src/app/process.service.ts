import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProcessService {

  private baseURL = "http://localhost:8081/api/v1/product";

  constructor(private httpClient: HttpClient) { }
  
  getProductList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL}`);
  }


  //createEmployee(employee: Employee): Observable<Object>{
  submitProducts(product: Product ): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, product);
  }
}
