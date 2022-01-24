package com.springRest.EmployeePayroll.dto;

import java.util.Date;

public class EmployeeDTO {

	public String name;
	public String gender;
	public String department;
	public long salary;
	public Date date;
	public String notes;

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
