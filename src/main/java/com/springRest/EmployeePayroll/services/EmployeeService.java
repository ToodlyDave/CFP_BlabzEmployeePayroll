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
import com.springRest.EmployeePayroll.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

// We declare this as a service so that it shows up as a component in autoscanning. 
//All the methods will work only if the correct token is passed to it. 
//The create method doesn't need a token, it will return a new token for the record it has inserted.
@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

	// We inject the employee repo into the service
	@Autowired
	EmployeeRepository employeeRepository;

	// We inject the token utilities into the service
	@Autowired
	TokenUtil tokenUtil;

	// This method prints the default hello world message
	@Override
	public ResponseEntity<String> helloWorld() {
		// TODO Auto-generated method stub
		log.info("Responding with welcome message");
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);

	}

	// This will return the employee we search for by id. If it doesn't find the
	// record of the given id it will
	// throw a custom exception. Which is handled by our custom exception handler.
	@Override
	public ResponseEntity<ResponseDTO> getEmployee(Optional<String> id, String token) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are retrieving employee information from the db");
		ResponseDTO responseDto;

		Long tokenId = tokenUtil.decodeToken(token);

		Optional<Employee> tokenEmployee = employeeRepository.findById(tokenId);

		if (tokenEmployee.isEmpty()) {
			responseDto = new ResponseDTO("ERROR: This is not an authorized user!", null, token);
			return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.UNAUTHORIZED);
		}

		if (id.isEmpty()) {
			List<Employee> empData = (List<Employee>) employeeRepository.findAll();
			responseDto = new ResponseDTO("Returning all the records stored in the db ", empData, token);
			ResponseEntity<ResponseDTO> responseThing = new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
			return responseThing;
		}

		Optional<Employee> employee = employeeRepository.findById(Long.parseLong(id.get()));
		Employee empData = employee.orElse(null);

		if (employee.isPresent()) {
			responseDto = new ResponseDTO("Found the employee record ", empData, token);
			return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
		}

		else {
			throw new EmployeeNotFound("ERROR: Could not find the employee record! ");
		}

	}

	// This will insert a new employee into the database. It will go through
	// validation and will throw an error if
	// the validation doesn't pass.
	@Override
	public ResponseEntity<ResponseDTO> postEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		log.info("We are saving a new employee record in the db");
		Employee empData = employeeRepository.save(new Employee(employee));
		String token = tokenUtil.createToken(empData.getId());
		ResponseDTO responseDto = new ResponseDTO("New Employee record has been stored successfully", empData, token);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	// This will update an existing employee in the database. If it doesn't find the
	// record of the given id it will
	// throw a custom exception. Which is handled by our custom exception handler.
	@Override
	public ResponseEntity<ResponseDTO> updateEmployee(String id, @Valid EmployeeDTO employee, String token)
			throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are updating an employee record in the db");

		Long idToken = tokenUtil.decodeToken(token);
		Optional<Employee> employeeToken = employeeRepository.findById(idToken);

		if (employeeToken.isEmpty()) {
			ResponseDTO responseDto = new ResponseDTO("ERROR: This is not an authorized user!", null, token);
			return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.UNAUTHORIZED);
		}

		Optional<Employee> emp = employeeRepository.findById(Long.parseLong(id));

		if (emp.isEmpty()) {
			throw new EmployeeNotFound(" ERROR: Employee record not found!");
		}

		Employee newEmployee = new Employee(employee);
		newEmployee.setId(Long.parseLong(id));
		
		Employee empData = employeeRepository.save(newEmployee);

		ResponseDTO responseDto = new ResponseDTO(" Employee record has been updated", empData, null);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	// This will delete an employee record from the database. If it doesn't find the
	// record of the given id it will
	// throw a custom exception. Which is handled by our custom exception handler.
	@Override
	public ResponseEntity<ResponseDTO> deleteEmployee(String id, String token) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		log.info("We are deleting an employee record");

		Long idToken = tokenUtil.decodeToken(token);
		Optional<Employee> employeeToken = employeeRepository.findById(idToken);

		if (employeeToken.isEmpty()) {
			ResponseDTO responseDto = new ResponseDTO("ERROR: This is not an authorized user!", null, token);
			return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.UNAUTHORIZED);
		}

		if (employeeRepository.findById(Long.parseLong(id)).isPresent()) {
			employeeRepository.deleteById(Long.parseLong(id));
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(" Employee record deleted!", null, null),
					HttpStatus.OK);
		} else
			throw new EmployeeNotFound("ERROR: No such employee record found!");
	}

	// This method will return a list of the employees with the department name
	// passes to it. It calls the custom
	// query that we have designed in the repository.
	@Override
	public ResponseEntity<ResponseDTO> findEmployeeByDept(String department, String token) throws EmployeeNotFound {
		// TODO Auto-generated method stub

		Long idToken = tokenUtil.decodeToken(token);
		Optional<Employee> employeeToken = employeeRepository.findById(idToken);

		if (employeeToken.isEmpty()) {
			ResponseDTO responseDto = new ResponseDTO("ERROR: This is not an authorized user!", null, token);
			return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.UNAUTHORIZED);
		}

		List<Employee> employee = employeeRepository.findEmployeeByDepartment(department);

		if (employee.size() == 0) {
			throw new EmployeeNotFound("ERROR: No such employee record found!");
		}

		ResponseDTO response = new ResponseDTO(" Showing all employee records with the requested department", employee,
				null);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

}
