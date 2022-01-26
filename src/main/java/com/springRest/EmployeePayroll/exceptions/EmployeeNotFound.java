package com.springRest.EmployeePayroll.exceptions;

public class EmployeeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message) {
		super(message);
	}

}
