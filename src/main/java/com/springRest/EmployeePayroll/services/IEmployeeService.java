package com.springRest.EmployeePayroll.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springRest.EmployeePayroll.dto.EmployeeDTO;
import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.exceptions.EmployeeNotFound;

public interface IEmployeeService {

	public ResponseEntity<String> helloWorld();

	public ResponseEntity<ResponseDTO> getEmployee(Optional<String> id) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> postEmployee(EmployeeDTO employee);

	public ResponseEntity<ResponseDTO> updateEmployee(String id, EmployeeDTO employee) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> deleteEmployee(String id) throws EmployeeNotFound;

	public ResponseEntity<ResponseDTO> findEmployeeByDept(String department) throws EmployeeNotFound;
}
