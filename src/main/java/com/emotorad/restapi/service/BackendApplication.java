package com.emotorad.restapi.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Main application class for starting the Spring Boot backend application.
 * This class serves as the entry point for the application and bootstraps the Spring context.
 */
@SpringBootApplication
public class BackendApplication {
	/**
     * Main method to launch the Spring Boot application.
     *
     * @param args Command-line arguments (if any) passed to the application.
     */
	public static void main(String[] args) {
		 // Run the Spring Boot application, initializing all configurations and components.
		SpringApplication.run(BackendApplication.class, args);
	}

}