package com.krishantha.traning.salesmanager.service;

import java.util.List;

import com.krishantha.traning.salesmanager.model.Employee;
import com.krishantha.traning.salesmanager.repository.EmployeeRepository;
import com.krishantha.traning.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
