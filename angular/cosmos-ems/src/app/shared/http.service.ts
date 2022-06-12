import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../employees/Employees.model";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private employeeUrl: string = 'http://localhost:8000/employees';

  constructor(private http: HttpClient) {
  }

  fetchEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl);
  }
}
