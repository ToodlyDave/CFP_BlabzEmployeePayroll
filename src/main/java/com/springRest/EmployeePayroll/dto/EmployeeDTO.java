package com.springRest.EmployeePayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {

	@NotNull(message = "ERROR: Name cannot be null!")
	@NotEmpty(message = "ERROR: Name cannot be empty!")
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
	public String name;
	
	@NotNull(message = "ERROR: Salary cannot be null!")
	@Min(value = 5000, message = "ERROR: Please enter a salary greater than 5000")
	public long salary;
	
	public String gender;
	public List<String> department;
	public LocalDate startDate;
	public String notes;
	public String profilePic;

}
