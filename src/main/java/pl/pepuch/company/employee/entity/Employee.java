package pl.pepuch.company.employee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
//@Table(name="EMPLOYEE") // TOD change to employee
@SuppressWarnings("serial")
@NamedQueries ({
	@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e"),
	@NamedQuery(name="Employee.findByName", query="SELECT e FROM Employee e WHERE e.name = :name"),
	@NamedQuery(name="Employee.findBySurname", query="SELECT e FROM Employee e WHERE e.surname = :surname"),
	@NamedQuery(name="Employee.findByProfit", query="SELECT e FROM Employee e WHERE e.profit>=:min AND e.profit<=:max"),
	@NamedQuery(name="Employee.findByDateOfBirth", query="SELECT e FROM Employee e WHERE e.dateOfBirth>=:startDate AND e.dateOfBirth<=:endDate")
})
public class Employee implements Serializable {

	@Id
	@Column(name="pesel")
	private long pesel;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="profit")
	private int profit;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	public Employee(long pesel, String name, String surname, int profit, Date dateOfBirth) {
		super();
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
		this.profit = profit;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}

	public long getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("Employee (id: %d, name: %s, surname: %s, profit: %d, dateOfBirth: %s)", pesel, name, surname, profit, dateOfBirth.toString());
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Employee) && ((Employee)o).getPesel()==pesel;
	}

	@Override
	public int hashCode() {
		return surname.hashCode();
	}

}
