package com.springRest.EmployeePayroll.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;
import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.entities.Employee;
import com.springRest.EmployeePayroll.exceptions.EmployeeNotFound;
import com.springRest.EmployeePayroll.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

// We declare this as a service so that it shows up as a component in autoscanning
@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

	// We inject the employee repo into the service
	@Autowired
	EmployeeRepository employeeRepository;

	// This method prints the default hello world message
	@Override
	public ResponseEntity<String> helloWorld() {
		// TODO Auto-generated method stub
		log.info("Responding with welcome message");
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
		
	}

	// This will return the employee we search for by id
	@Override
	public ResponseEntity<ResponseDTO> getEmployee(Optional<String> id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are retrieving employee information from the db");
		ResponseDTO responseDto;
		if (id.isEmpty()) {
			List<Employee> empData = (List<Employee>) employeeRepository.findAll();
			responseDto = new ResponseDTO("Returning all the records stored in the db ", empData);
			ResponseEntity<ResponseDTO> responseThing = new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
			return responseThing;
		}

		Optional<Employee> employee = employeeRepository.findById(Long.parseLong(id.get()));
		Employee empData = employee.orElse(null);

		if (employee.isPresent()) {
			responseDto = new ResponseDTO("Found the employee record ", empData);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO("Found the employee record ", empData), HttpStatus.OK);
		}

		else {
			throw new EmployeeNotFound("ERROR: Could not find the employee record! ");
		}

	}

	// This will insert a new employee into the database
	@Override
	public ResponseEntity<ResponseDTO> postEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		log.info("We are saving a new employee record in the db");
		Employee empData = employeeRepository.save(new Employee(employee));
		ResponseDTO responseDto = new ResponseDTO("New Employee record has been stored successfully", empData);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	// This will update an existing employee in the database
	@Override
	public ResponseEntity<ResponseDTO> updateEmployee(String id, @Valid EmployeeDTO employee) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are updating an employee record in the db");
		Optional<Employee> emp = employeeRepository.findById(Long.parseLong(id));
		
		if (emp.isEmpty()) {
			throw new EmployeeNotFound(" ERROR: Employee record not found!");
		}

		Employee empData = employeeRepository.save(new Employee(Long.parseLong(id), employee));

		ResponseDTO responseDto = new ResponseDTO(" Employee record has been updated", empData);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	// This will delete an employee record from the database
	@Override
	public ResponseEntity<ResponseDTO> deleteEmployee(String id) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are deleting an employee record");
		if (employeeRepository.findById(Long.parseLong(id)).isPresent()) {
			employeeRepository.deleteById(Long.parseLong(id));
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(" Employee record deleted!", null), HttpStatus.OK);
		} 
		else
			throw new EmployeeNotFound("ERROR: No such employee record found!");
	}

}
