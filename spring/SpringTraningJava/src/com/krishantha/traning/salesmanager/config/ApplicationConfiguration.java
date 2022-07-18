package com.krishantha.traning.salesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.krishantha.traning.salesmanager.repository.EmployeeRepository;
import com.krishantha.traning.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.krishantha.traning.salesmanager.service.EmployeeService;
import com.krishantha.traning.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.krishantha")
public class ApplicationConfiguration {

	@Bean("employeeService")
//	@Scope("singleton")
	@Scope("prototype")
	public EmployeeService getEmployeeService() {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
	}

	// We added HibernateEmployeeRepositoryImpl as Repository hence this is no need
//	@Bean("employeeRepository")
//	public EmployeeRepository getEmployeeRepository() {
//		return new HibernateEmployeeRepositoryImpl();
//	}
}
