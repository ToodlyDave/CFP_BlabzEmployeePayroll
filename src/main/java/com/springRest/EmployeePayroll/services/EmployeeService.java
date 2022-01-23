package com.springRest.EmployeePayroll.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.EmployeePayroll.entities.Employee;
import com.springRest.EmployeePayroll.repo.EmployeeRepository;

// We declare this as a service so that it shows up as a component in autoscanning
@Service
public class EmployeeService implements IEmployeeService {

	// We inject the employee repo into the service
	@Autowired
	EmployeeRepository employeeRepository;

	// This method prints the default hello world message
	@Override
	public String helloWorld() {
		// TODO Auto-generated method stub
		return "Hello World!";
	}

	// This will return the employee we search for by id
	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(Long.parseLong(id));
		if (employee.isPresent()) {
			return employee.get();
		} else
			return null;
	}

	// This will insert a new employee into the database
	@Override
	public Employee postEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	// This will update an existing employee in the database
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if (emp.isPresent()) {
			return employeeRepository.save(employee);
		}

		return null;
	}

	// This will delete an employee record from the database
	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		if (employeeRepository.findById(Long.parseLong(id)).isPresent()) {
			employeeRepository.deleteById(Long.parseLong(id));
			return " Employee record deleted!";
		} else
			return " No such employee record found!";
	}

}
