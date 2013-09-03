package pl.pepuch.company.employee;

import java.util.Date;
import java.util.List;
import pl.pepuch.company.employee.entity.Employee;

public interface EmployeeRemoteBusiness {

	Employee addEmployee(Employee employee);

	List<Employee> addEmployees(List<Employee> employees);

	void removeEmployee(Employee employee);

	void removeEmployees(List<Employee> employees);

	Employee getEmployee(long pesel);
	
	List<Employee> listEmployees();
	
	List<Employee> findEmployeeByName(String name);
	
	List<Employee> findEmployeeBySurname(String surname);
	
	List<Employee> findEmployeeByProfit(int min, int max);
	
	List<Employee> findEmployeeByDateOfBirth(Date startData, Date endData);
	
}
