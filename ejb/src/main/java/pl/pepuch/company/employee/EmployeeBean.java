package pl.pepuch.company.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.pepuch.company.employee.entity.Employee;

@Stateless
public class EmployeeBean implements EmployeeRemoteBusiness {

	@PersistenceContext(unitName="companyPU")
	private EntityManager em;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return em.merge(employee);
	}

	@Override
	public List<Employee> addEmployees(List<Employee> employees) {
		List<Employee> addedEmployees = new ArrayList<Employee>();
		for (Employee e : employees) {
			addedEmployees.add(em.merge(e));
		}
		return addedEmployees;
	}

	@Override
	public void removeEmployee(Employee employee) {
		em.remove(em.merge(employee));
	}

	@Override
	public void removeEmployees(List<Employee> employees) {
		for (Employee e : employees) {
			em.remove(em.merge(e));
		}
	}

	@Override
	public List<Employee> listEmployees() {
		TypedQuery<Employee> employees = em.createNamedQuery("Employee.findAll", Employee.class);
		return employees.getResultList();
	}

	@Override
	public Employee getEmployee(long pesel) {
		return em.find(Employee.class, pesel);
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {
		TypedQuery<Employee> employees = em.createNamedQuery("Employee.findByName", Employee.class).setParameter("name", name);
		return employees.getResultList();
	}

	@Override
	public List<Employee> findEmployeeBySurname(String surname) {
		TypedQuery<Employee> employees = em.createNamedQuery("Employee.findBySurname", Employee.class).setParameter("surname", surname);
		return employees.getResultList();
	}

	@Override
	public List<Employee> findEmployeeByProfit(int min, int max) {
		TypedQuery<Employee> employees = em.createNamedQuery("Employee.findByProfit", Employee.class).setParameter("min", min).setParameter("max", max);
		return employees.getResultList();
	}

	@Override
	public List<Employee> findEmployeeByDateOfBirth(Date startDate, Date endDate) {
		TypedQuery<Employee> employees = em.createNamedQuery("Employee.findByDateOfBirth", Employee.class).setParameter("startDate", startDate).setParameter("endDate", endDate);
		return employees.getResultList();
	}
	
}
