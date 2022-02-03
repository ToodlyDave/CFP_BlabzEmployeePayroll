package com.springRest.EmployeePayroll.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	// We declare id as the primary key which will auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String email;
	private String gender;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	private List<String> department;
	private long salary;

	// Setting the date format for sql
	@Column(name = "start_date")
	private LocalDate startDate;

	private String notes;

	@Column(name = "profile_pic")
	private String profilePic;
	
	private boolean verified;

	public Employee(EmployeeDTO employee) {
		super();
		this.name = employee.name;
		this.email = employee.email;
		this.gender = employee.gender;
		this.department = employee.department;
		this.salary = employee.salary;
		this.startDate = employee.startDate;
		this.notes = employee.notes;
		this.profilePic = employee.profilePic;
		this.verified = false;
	}

}
