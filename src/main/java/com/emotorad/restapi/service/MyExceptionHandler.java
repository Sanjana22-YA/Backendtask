package com.emotorad.restapi.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
/**
 * Exception handler class for handling specific exceptions across the application.
 * This class will manage exceptions globally and return meaningful error responses to the client.
 */
@RestControllerAdvice
public class MyExceptionHandler {
	/**
     * Handles the case when a NoResourceFoundException is thrown.
     * This can happen when the URL requested does not map to any resource in the application.
     *
     * @return A response entity with an error message and a 404 (NOT_FOUND) status.
     */
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> handle() {
		// Creating a map to store the error details
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "Url is Incorrect , check and try");
		 // Returning a response entity with the error map and HTTP 404 status
		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}
	/**
     * Handles the case when a MethodArgumentTypeMismatchException is thrown.
     * This can happen when there is a mismatch between the expected argument type in the URL or request body.
     *
     * @return A response entity with an error message and a 400 (BAD_REQUEST) status.
     */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handle1() {
		// Creating a map to store the error details
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "Enter Proper Value in the Path");
		 // Returning a response entity with the error map and HTTP 400 status
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

}