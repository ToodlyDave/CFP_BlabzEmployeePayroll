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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping(value = { "", "/" })
	public String hello() {
		return employeeService.helloWorld();
	}

	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/create")
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeService.postEmployee(employee);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
}
