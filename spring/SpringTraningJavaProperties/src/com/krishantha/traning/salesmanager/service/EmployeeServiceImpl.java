package com.krishantha.traning.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.krishantha.traning.salesmanager.model.Employee;
import com.krishantha.traning.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    	System.out.println("Overload constructor executed");
    	this.employeeRepository = employeeRepository;
    }
    
    public EmployeeServiceImpl() {
    	System.out.println("Default constructor executed");
    }
    
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter executed");
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
