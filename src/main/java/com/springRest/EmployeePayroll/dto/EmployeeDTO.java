package com.springRest.EmployeePayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDTO {

	@NotNull(message = "ERROR: Name cannot be null!")
	@NotEmpty(message = "ERROR: Name cannot be empty!")
	@Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
	public String name;
	
	@NotNull(message = "ERROR: Salary cannot be null!")
	@Min(value = 5000, message = "ERROR: Please enter a salary greater than 5000")
	public long salary;
	
	@NotNull
	@Pattern(regexp = "^(male|female|other)$", message = "ERROR: Please enter a valid gender")
	public String gender;
	
	@NotNull
	public List<String> department;
	
	@JsonFormat(pattern = "dd MM yyyy")
	@NotNull(message = "ERROR: The start date cannot be empty!")
	@PastOrPresent(message = "ERROR: The start date cannot be in the future!")
	public LocalDate startDate;
	
	@NotNull(message = "ERROR: The notes cannot be left empty")
	public String notes;
	
	@NotNull(message = "ERROR: The profile picture has to be provided")
	public String profilePic;

}
