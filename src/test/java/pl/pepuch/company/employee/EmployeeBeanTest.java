package pl.pepuch.company.employee;

import org.junit.Test;

import pl.pepuch.company.employee.entity.Employee;

public class EmployeeBeanTest {

	@Test
	public void addEmployee() {
		Employee employee = new Employee("Patryk", "Rsozczyniala", 1000, 0);
		EmployeeBean bean = new EmployeeBean();
		bean.addEmployee(employee);
	}

}
