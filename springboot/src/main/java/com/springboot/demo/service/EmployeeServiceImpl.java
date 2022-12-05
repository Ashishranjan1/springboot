package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.demo.dao.EmployeeRepo;
import com.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee getEmployee(int id) {
		Optional<Employee> empOpt = employeeRepo.findById(id);
		if (empOpt.isPresent())
			return empOpt.get();
		else {
			throw new RuntimeException("Employee not found with id " + id);

		}
	}

	public List<Employee> getEmployees() {

		return (List<Employee>) employeeRepo.findAll();

	}

	@Override
	public Employee addEmployee(Employee emp) {

		employeeRepo.save(emp);

		return emp;
	}

	public Employee updateEmployee(Employee emp) {

		employeeRepo.save(emp);
		return emp;
	}

	public Employee deleteEmployee(Integer id) {
		Optional<Employee> empOpt = employeeRepo.findById(id);
		if (empOpt.isPresent()) {
			Employee emp = empOpt.get();

			employeeRepo.delete(emp);
			return emp;
		} else
			throw new RuntimeException("Employee not found with id " + id);

	}

}
