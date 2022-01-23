package com.springRest.EmployeePayroll.services;

import com.springRest.EmployeePayroll.entities.Employee;

public interface IEmployeeService {

	public String helloWorld();
	
	public Employee getEmployee(String id);
	
	public Employee postEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public String deleteEmployee(String id);

}
