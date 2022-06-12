import {Component, OnDestroy, OnInit} from '@angular/core';
import {Employee} from "./Employees.model";
import {EmployeeService} from "./employee.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit, OnDestroy {

  title: string = "Employee Management System";
  employees!: Employee[];
  filteredEmployees!: Employee[];
  showIcon: boolean = true;
  message: string = '';
  subscriber!: Subscription;
  private _designationFilter: string = '';


  get designationFilter(): string {
    return this._designationFilter;
  }

  set designationFilter(value: string) {
    this._designationFilter = value;
    this.filterEmployeesByDesignation();
  }

  constructor(private employeeService: EmployeeService) {
  }

  ngOnDestroy(): void {
    this.subscriber.unsubscribe();
  }

  ngOnInit(): void {
    this.subscriber = this.employeeService.getEmployeeList().subscribe({
      next: data => {
        console.log(data);
        this.filteredEmployees = data;
        this.employees = this.filteredEmployees;
      }
    });
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
}
