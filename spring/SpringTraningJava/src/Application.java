import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.krishantha.traning.salesmanager.config.ApplicationConfiguration;
import com.krishantha.traning.salesmanager.model.Employee;
import com.krishantha.traning.salesmanager.service.EmployeeService;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());
		}
	}
}
