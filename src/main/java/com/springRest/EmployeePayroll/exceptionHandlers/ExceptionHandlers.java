package com.springRest.EmployeePayroll.exceptionHandlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.exceptions.EmployeeNotFound;

@ControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<ResponseDTO> handleEmployeeNotFound(EmployeeNotFound error) {
		ResponseDTO response = new ResponseDTO("Invalid id input", error.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleInvalidExceptions(MethodArgumentNotValidException error) {
		List<String> errorMessage = error.getAllErrors().stream()
										.map(errorObject -> errorObject.getDefaultMessage())
										.collect(Collectors.toList());
		
		ResponseDTO response = new ResponseDTO("Invalid input", errorMessage);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
