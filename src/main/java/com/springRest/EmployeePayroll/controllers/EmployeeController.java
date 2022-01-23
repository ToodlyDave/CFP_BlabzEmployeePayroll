package com.springRest.EmployeePayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.EmployeePayroll.entities.Employee;
import com.springRest.EmployeePayroll.services.IEmployeeService;

// This is the rest controller, it is monitoring the /employeepayrollservice endpoint
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

	// We inject the service here
	@Autowired
	IEmployeeService employeeService;

	// This will display the default hello world message
	@GetMapping(value = { "", "/" })
	public String hello() {
		return employeeService.helloWorld();
	}

	// This will call the service layer to get an employee we search for by id
	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	// This will call the service layer to create a new employee record in the
	// database
	@PostMapping("/create")
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeService.postEmployee(employee);
	}

	// This will call the service layer to update an employee record
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	// This will delete an employee record, specified by id, from the database
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
}
