package com.springRest.EmployeePayroll.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;
import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.exceptions.EmployeeNotFound;

// This is the interface for the service class. This will be used when injecting the service as a dependency via autowired
public interface IEmployeeService {

	public ResponseEntity<String> helloWorld();

	public ResponseEntity<ResponseDTO> getEmployee(Optional<String> id, String token) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> postEmployee(EmployeeDTO employee);

	public ResponseEntity<ResponseDTO> updateEmployee(String id, EmployeeDTO employee, String token) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> deleteEmployee(String id, String token) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> findEmployeeByDept(String department, String token) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> verify(String token);
}
