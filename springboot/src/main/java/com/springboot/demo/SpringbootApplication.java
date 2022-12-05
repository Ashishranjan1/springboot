package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.demo.dao.EmployeeRepo;
import com.springboot.demo.entity.Employee;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {

		System.out.println("My first project.");

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		EmployeeRepo empRepo = context.getBean(EmployeeRepo.class);

		Iterable<Employee> emp = empRepo.findAll();

		for (Employee e : emp)
			System.err.println(e.getFirstName());

	}

}
