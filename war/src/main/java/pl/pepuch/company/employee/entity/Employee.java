package pl.pepuch.company.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private static final long serialVersionUID = 2441886119915635628L;
	private long pesel;
	private String name;
	private String surname;
	private int profit;
	private long dateOfBirth;
	
	public Employee(long pesel, String name, String surname, int profit, Date dateOfBirth) {
		super();
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
		this.profit = profit;
		this.dateOfBirth = dateOfBirth.getTime();
	}

	public Employee() {
		super();
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

	public Date getDateOfBirth() {
		return new Date(dateOfBirth);
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth.getTime();
	}

	@Override
	public String toString() {
		return String.format("Employee (id: %d, name: %s, surname: %s, profit: %d, dateOfBirth: %d)", pesel, name, surname, profit, dateOfBirth);
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
