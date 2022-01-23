package com.springRest.EmployeePayroll.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	public String name;
	public String gender; 
	public String department;
	public long salary;

	@Temporal(TemporalType.DATE)
	public Date date;
	public String notes;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public Employee(String name, String lastName, String gender, String department, long salary, Date date,
			String notes) {
		super();
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.date = date;
		this.notes = notes;
	}

}
