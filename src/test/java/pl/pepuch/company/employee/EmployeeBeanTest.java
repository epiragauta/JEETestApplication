package pl.pepuch.company.employee;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.pepuch.company.employee.entity.Employee;

public class EmployeeBeanTest {

	private static EJBContainer ejbContainer;
	private static Context context;
	
	@BeforeClass
	public static void setUpClass() {
		ejbContainer = EJBContainer.createEJBContainer();
		System.out.println("Starting the container");
		context = ejbContainer.getContext();
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer!=null) ejbContainer.close();
		System.out.println("Closing the container");
	}
	
	@Test
	public void addEmployee() throws NamingException {
		EmployeeRemoteBusiness employeeBean = (EmployeeRemoteBusiness) context.lookup("java:global/main/EmployeeBean");
		Employee employee = new Employee("Patryk1", "Rsozczyniala", 1000, 0);
		employeeBean.addEmployee(employee);
		Employee e = employeeBean.getEmployee(1);
		System.out.println(e);
	}

}
