package com.krishantha.traning.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.krishantha.traning.salesmanager.model.Employee;

@Repository("myDatabase")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

@Override
public List<Employee> getAllEmployees() {
	System.out.println("hit");
	List<Employee> employees = new ArrayList<>();
	Employee employee = new Employee();
	employee.setEmployeeLocation("Krish");
	employee.setEmployeeName("Kadawatha");
	employees.add(employee);
	return employees;
	}
}
