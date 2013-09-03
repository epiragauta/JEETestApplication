package pl.pepuch.company.employee;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import pl.pepuch.company.employee.entity.Employee;

@ManagedBean
public class EmployeeListBean {

	@EJB(lookup="java:global/jee-ejb-company-git/EmployeeBean")
	private EmployeeRemoteBusiness employeeBusiness;

	public List<Employee> getEmployees() {
		return employeeBusiness.listEmployees();
	}

	public EmployeeRemoteBusiness getEmployeeBusiness() {
		return employeeBusiness;
	}

	public void setEmployeeBusiness(EmployeeRemoteBusiness employeeBusiness) {
		this.employeeBusiness = employeeBusiness;
	}
	
}
