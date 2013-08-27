package pl.pepuch.company.employee;

import java.util.List;

import javax.ejb.Local;

import pl.pepuch.company.employee.entity.Employee;
import pl.pepuch.company.employee.entity.EmployeeSearchData;

@Local
public interface EmployeeRemoteBusiness {

	void addEmployee(Employee employee);

	void addEmployees(List<Employee> employees);

	void removeEmployee(Employee employee);

	void removeEmployees(List<Employee> employees);

	List<Employee> listEmployees();
	
	List<Employee> findEmployees(EmployeeSearchData data);

}
