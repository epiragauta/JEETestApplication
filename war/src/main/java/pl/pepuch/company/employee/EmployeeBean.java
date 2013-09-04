package pl.pepuch.company.employee;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import pl.pepuch.company.employee.entity.Employee;

@ManagedBean
public class EmployeeBean {

	@EJB(lookup="java:global/jee-ejb-company-git/EmployeeBean")
	private EmployeeRemoteBusiness employeeBusiness;
	private long pesel;
	private String name;
	private String surname;
	private int profit;
	private long dateOfBirth;

	public void add(ActionEvent e) {
		Employee employee = new Employee(pesel, name, surname, profit, new Date(dateOfBirth));
		employeeBusiness.addEmployee(employee);
	}
	
	public void remove(Employee e) {
		employeeBusiness.removeEmployee(e);
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

	public long getPesel() {
		return pesel;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
