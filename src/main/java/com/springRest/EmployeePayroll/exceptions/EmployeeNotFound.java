package com.springRest.EmployeePayroll.exceptions;

// This is our custom exception.
public class EmployeeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message) {
		super(message);
	}

}
