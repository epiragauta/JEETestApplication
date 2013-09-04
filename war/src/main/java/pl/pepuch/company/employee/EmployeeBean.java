package pl.pepuch.company.employee;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import pl.pepuch.company.employee.entity.Employee;

@ManagedBean
public class EmployeeBean {

	@EJB(lookup="java:global/jee-ejb-company-git/EmployeeBean")
	private EmployeeRemoteBusiness employeeBusiness;
	private Employee employee;

	public void add(ActionEvent e) {
		Employee employee = new Employee();
		employeeBusiness.addEmployee(employee);
	}
	
	public String remove() {
		employeeBusiness.removeEmployee(employee);
		return null;
	}

	public EmployeeRemoteBusiness getEmployeeBusiness() {
		return employeeBusiness;
	}

	public void setEmployeeBusiness(EmployeeRemoteBusiness employeeBusiness) {
		this.employeeBusiness = employeeBusiness;
	}
	
	public List<Employee> getEmployees() {
		return employeeBusiness.listEmployees();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
