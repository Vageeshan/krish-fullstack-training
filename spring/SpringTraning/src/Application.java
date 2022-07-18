import java.util.List;

import com.krishantha.traning.salesmanager.model.Employee;
import com.krishantha.traning.salesmanager.service.EmployeeService;
import com.krishantha.traning.salesmanager.service.EmployeeServiceImpl;

public class Application {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+ " at " + employee.getEmployeeLocation());
		}
	}
}
