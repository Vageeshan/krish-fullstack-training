package com.krishantha.traning.salesmanager.service;

import java.util.List;

import com.krishantha.traning.salesmanager.model.Employee;
import com.krishantha.traning.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

  
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
