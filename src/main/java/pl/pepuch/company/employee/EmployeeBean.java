package pl.pepuch.company.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import pl.pepuch.company.employee.entity.Employee;
import pl.pepuch.company.employee.entity.EmployeeSearchData;

@Stateless
public class EmployeeBean implements EmployeeRemoteBusiness {

	@Override
	public void addEmployee(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("companyPU");
		System.out.println("emf: "+emf);
		EntityManager em = emf.createEntityManager();
		System.out.println("em: "+em);
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void addEmployees(List<Employee> employees) {
	}

	@Override
	public void removeEmployee(Employee employee) {
	}

	@Override
	public void removeEmployees(List<Employee> employees) {
	}

	@Override
	public List<Employee> listEmployees() {
		return null;
	}

	@Override
	public List<Employee> findEmployees(EmployeeSearchData data) {
		return null;
	}

}
