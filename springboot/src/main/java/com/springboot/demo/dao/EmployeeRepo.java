package com.springboot.demo.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.entity.Employee;
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

	public List<Employee> findAllByOrderByFirstNameAsc();

}
