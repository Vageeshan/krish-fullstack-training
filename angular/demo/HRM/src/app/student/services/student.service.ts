import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "../model/student";

interface ResponseStudent {
  recordCount: number;
  response: Student[];
}

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseURL = 'http://localhost:8080/api/v1/student';

  constructor(private httpClient: HttpClient) {
  }

  getStudentList(): Observable<ResponseStudent> {
    return this.httpClient.get<ResponseStudent>(`${this.baseURL}`);
  }

  saveStudent(payload: Student): Observable<Student> {
    return this.httpClient.post<Student>(`${this.baseURL}`, payload);
  }

  getStudentById(id: number): Observable<Student> {
    return this.httpClient.get<Student>(`${this.baseURL}/${id}`);
  }

  updateStudent(id: number, payload: Student): Observable<Student> {
    return this.httpClient.put<Student>(`${this.baseURL}/${id}`, payload);
  }

  deleteStudentById(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
