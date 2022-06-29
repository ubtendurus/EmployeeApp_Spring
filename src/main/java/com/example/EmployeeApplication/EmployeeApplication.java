package com.example.EmployeeApplication;

import com.example.EmployeeApplication.entity.Address;
import com.example.EmployeeApplication.entity.Employee;
import com.example.EmployeeApplication.entity.Project;
import com.example.EmployeeApplication.entity.Spouse;
import com.example.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService){
		return(args) -> {

			Address address1 = new Address("Line 1", "Line 2","ZipCode1","City1","State1","Country1");
			Project project1 = new Project("Name1", "Client Name1");
			Spouse spouse1 = new Spouse("Name 1", "Phone1",29);

			Employee employee = new Employee("Employee 1", "City 1");
			employee.addProject(project1);
			employee.addAddress(address1);
			employee.setSpouse(spouse1);

			employeeService.createEmployee(employee);

			System.out.println("Getting an employee");
			Employee employee1 = employeeService.getAnEmployee(1);

		};
	}
}
