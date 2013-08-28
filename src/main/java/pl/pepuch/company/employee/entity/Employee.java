package pl.pepuch.company.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
//@Table(name="EMPLOYEE") // TOD change to employee
@SuppressWarnings("serial")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="profit")
	private int profit;
	@Column(name="date_of_birth")
	private int dateOfBirth;
	
	public Employee(String name, String surname, int profit, int dateOfBirth) {
		super();
		this.name = name;
		this.surname = surname;
		this.profit = profit;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("Employee (id: %d, name: %s, surname: %s, profit: %d, dateOfBirth: %d)", id, name, surname, profit, dateOfBirth);
	}

}
