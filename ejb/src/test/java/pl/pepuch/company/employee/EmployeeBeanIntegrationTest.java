package pl.pepuch.company.employee;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.pepuch.company.employee.entity.Employee;

public class EmployeeBeanIntegrationTest {

	private EJBContainer ejbContainer;
	private Context context;
	private EmployeeRemoteBusiness employeeBean;
	private Employee employeeJasFasola;
	private Employee employeeGeniekFasola;
	private Employee employeeGeniekKielbasa;
	
	@Before
	public void setUpClass() throws NamingException {
		ejbContainer = EJBContainer.createEJBContainer(); // TODO change glassfish EJBContainer to faster version (openejb?)
		System.out.println("Starting the container");
		context = ejbContainer.getContext();
		employeeBean = (EmployeeRemoteBusiness) context.lookup("java:global/main/EmployeeBean");
		employeeJasFasola = new Employee(51110232111L, "Jas", "Fasola", 2300, new DateTime(1956, 11, 14, 12, 34).toDate());
		employeeGeniekFasola = new Employee(78051834387L, "Geniek", "Fasola", 1000, new DateTime(1965, 04, 30, 10, 14).toDate());
		employeeGeniekKielbasa = new Employee(58111108342L, "Geniek", "Kielbasa", 1500, new DateTime(1986, 12, 11, 22, 10).toDate());
	}
	
	@After
	public void tearDownClass() {
		if (ejbContainer!=null) ejbContainer.close();
		System.out.println("Closing the container");
	}
	
	@Test
	public void addEmployee() throws NamingException {
		Employee addedEmployee = employeeBean.addEmployee(employeeJasFasola);
		assertEquals(employeeJasFasola, addedEmployee);
	}
	
	@Test
	public void removeExistingEmployee() {
		employeeBean.addEmployee(employeeJasFasola);
		assertTrue(employeeBean.listEmployees().size()==1);
		System.out.println("removeExistingEmployee | employeeBean.listEmployees().size(): "+employeeBean.listEmployees().size());
		employeeBean.removeEmployee(employeeJasFasola);
		assertTrue(employeeBean.listEmployees().size()==0);
		System.out.println("removeExistingEmployee | employeeBean.listEmployees().size(): "+employeeBean.listEmployees().size());
	}

	@Test
	public void removeExistingEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employeeJasFasola);
		employees.add(employeeGeniekFasola);
		List<Employee> addedEmployees = employeeBean.addEmployees(employees);
		assertTrue(addedEmployees.size()==2);
		assertTrue(employeeBean.listEmployees().size()==2);
		employeeBean.removeEmployees(employees);
		assertTrue(employeeBean.listEmployees().size()==0);
	}

	@Test
	public void getExistingEmployee() {
		employeeBean.addEmployee(employeeJasFasola);
		Employee foundEmployee = employeeBean.getEmployee(employeeJasFasola.getPesel());
		assertEquals(employeeJasFasola, foundEmployee);
	}
	
	@Test
	public void listEmployees() {
		employeeBean.addEmployee(employeeJasFasola);
		employeeBean.addEmployee(employeeGeniekFasola);
		System.out.println("list employees: "+employeeBean.listEmployees().size());
		assertTrue(employeeBean.listEmployees().size()==2);
	}
	
	@Test
	public void findEmployeeByName() {
		employeeBean.addEmployee(employeeJasFasola);
		employeeBean.addEmployee(employeeGeniekFasola);
		employeeBean.addEmployee(employeeGeniekKielbasa);
		List<Employee> foundEmployees = employeeBean.findEmployeeByName("Geniek");
		assertTrue(foundEmployees.size()==2);
		foundEmployees = employeeBean.findEmployeeByName("Jas");
		assertTrue(foundEmployees.size()==1);
	}
	
	@Test
	public void findEmployeeBySurname() {
		employeeBean.addEmployee(employeeJasFasola);
		employeeBean.addEmployee(employeeGeniekFasola);
		employeeBean.addEmployee(employeeGeniekKielbasa);
		List<Employee> foundEmployees = employeeBean.findEmployeeBySurname("Fasola");
		assertTrue(foundEmployees.size()==2);
		foundEmployees = employeeBean.findEmployeeBySurname("Kielbasa");
		assertTrue(foundEmployees.size()==1);
	}
	
	@Test
	public void findEmployeeByProfit() {
		employeeBean.addEmployee(employeeJasFasola);
		employeeBean.addEmployee(employeeGeniekFasola);
		employeeBean.addEmployee(employeeGeniekKielbasa);
		List<Employee> foundEmployees = employeeBean.findEmployeeByProfit(1001, 2000);
		assertTrue(foundEmployees.size()==1);
	}
	
	@Test
	public void findEmployeeByDateOfBirth() {
		employeeBean.addEmployee(employeeJasFasola);
		employeeBean.addEmployee(employeeGeniekFasola);
		employeeBean.addEmployee(employeeGeniekKielbasa);
		Date startDate = new DateTime(1960, 1, 1, 0, 0).toDate();
		Date endDate = new DateTime(1990, 1, 1, 0, 0).toDate();
		List<Employee> foundEmployees = employeeBean.findEmployeeByDateOfBirth(startDate, endDate);
		assertTrue(foundEmployees.size()==2);
	}

}
