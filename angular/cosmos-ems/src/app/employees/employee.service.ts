import {Injectable} from '@angular/core';
import {HttpService} from "../shared/http.service";
import {Observable} from "rxjs";
import {Employee} from "./Employees.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpService: HttpService) {

  }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpService.fetchEmployees();
  }
}
