package com.krishantha.traning.salesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.krishantha.traning.salesmanager.repository.EmployeeRepository;
import com.krishantha.traning.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.krishantha.traning.salesmanager.service.EmployeeService;
import com.krishantha.traning.salesmanager.service.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {

	@Bean("employeeService")
	public EmployeeService getEmployeeService() {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.setEmployeeRepository(getEmployeeRepository());
		return employeeService;
	}

	@Bean("employeeRepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
	}
}
