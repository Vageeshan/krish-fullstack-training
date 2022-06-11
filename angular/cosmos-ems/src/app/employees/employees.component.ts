import {Component, OnInit} from '@angular/core';
import employees from './mock/employees.json';
import {Employee} from "./Employees.model";

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  title: string = "Employee Management System";
  employees: Employee[] = employees;
  filteredEmployees: Employee[] = employees;
  showIcon: boolean = true;
  message: string = '';
  private _designationFilter: string = '';


  get designationFilter(): string {
    return this._designationFilter;
  }

  set designationFilter(value: string) {
    this._designationFilter = value;
    this.filterEmployeesByDesignation();
  }

  constructor() {
  }

  toggleIcon = () => {
    this.showIcon = !this.showIcon;
  }

  filterEmployeesByDesignation = () => {
    this.filteredEmployees = this.employees.filter(employee => employee.designation.toLowerCase().includes(this.designationFilter.toLowerCase()));
  }

  onMessageReceived = (value: string) => {
    this.message = value;
  }

  ngOnInit(): void {
  }
}
