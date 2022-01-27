package com.springRest.EmployeePayroll.exceptionHandlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springRest.EmployeePayroll.dto.ResponseDTO;
import com.springRest.EmployeePayroll.exceptions.EmployeeNotFound;

// This will handle all the exceptions thrown throughout the project.
// The following annotation indicates the same.
@ControllerAdvice
public class ExceptionHandlers {

	// This is to handle when the date format doesn't match the one we have
	// specified.
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleInvalidDate(HttpMessageNotReadableException error) {
		ResponseDTO response = new ResponseDTO("Invalid start date input", error.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}

	// This is to handle our custom exception when thrown
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<ResponseDTO> handleEmployeeNotFound(EmployeeNotFound error) {
		ResponseDTO response = new ResponseDTO("Invalid input", error.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}

	// This is to handle the invalid pattern exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleInvalidExceptions(MethodArgumentNotValidException error) {
		List<String> errorMessage = error.getAllErrors().stream().map(errorObject -> errorObject.getDefaultMessage())
				.collect(Collectors.toList());

		ResponseDTO response = new ResponseDTO("Invalid input", errorMessage);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.BAD_REQUEST);
	}
}
