package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// This is the main class for the API. It has the main method that runs the API. The @SpringBootApplication annotation tells spring boot to start the application and to scan for other components, such as controllers and repositories, in the same package and subpackages.
@SpringBootApplication
// This annotation tells spring boot "This is the main class for the API. It will start the application and scan for other components, such as controllers and repositories, in the same package and subpackages."
public class CampusResourceManagementApiApplication {
// The main method is the entry point for the application. It runs the application by calling SpringApplication.run and passing in the main class and the command line arguments.
	public static void main(String[] args) {
		SpringApplication.run(CampusResourceManagementApiApplication.class, args);
	}

}
