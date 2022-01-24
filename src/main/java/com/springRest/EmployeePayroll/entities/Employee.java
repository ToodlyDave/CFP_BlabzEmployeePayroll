package com.springRest.EmployeePayroll.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;

@Entity
public class Employee {

	// We declare id as the primary key which will auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	public String name;
	public String gender;
	public String department;
	public long salary;

	// Setting the date format for sql
	@Temporal(TemporalType.DATE)
	public Date date;

	public String notes;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public Employee(EmployeeDTO employee) {
		super();
		this.name = employee.name;
		this.gender = employee.gender;
		this.department = employee.department;
		this.salary = employee.salary;
		this.date = employee.date;
		this.notes = employee.notes;
	}

	public Employee(long id, EmployeeDTO employee) {
		super();
		this.id = id;
		this.name = employee.name;
		this.gender = employee.gender;
		this.department = employee.department;
		this.salary = employee.salary;
		this.date = employee.date;
		this.notes = employee.notes;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public long getSalary() {
		return salary;
	}

	public Date getDate() {
		return date;
	}

	public String getNotes() {
		return notes;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
