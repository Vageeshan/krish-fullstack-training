import {Component, OnInit} from '@angular/core';
import employees from './mock/employees.json';

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  title: string = "Employee Management System";
  employees: any[] = employees;
  filteredEmployees: any[] = employees;
  showIcon: boolean = true;
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
    this.filteredEmployees = this.employees.filter(employee => employee.designation.includes(this.designationFilter));
  }

  ngOnInit(): void {
  }
}
