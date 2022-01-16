import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8081/api/v1/user";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  login(user: User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL} + 'user' `, user);
  }
}
