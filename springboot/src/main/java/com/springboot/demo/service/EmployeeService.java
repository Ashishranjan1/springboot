package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.entity.Employee;

public interface EmployeeService {

	public Employee getEmployee(int id);

	public List<Employee> getEmployees();

	public Employee addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);
	public Employee deleteEmployee(Integer id);



}
