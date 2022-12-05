package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.demo.dao.EmployeeRepo;
import com.springboot.demo.entity.Employee;
import com.springboot.demo.service.EmployeeService;

@org.springframework.stereotype.Controller
@RequestMapping("/employees")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepo employeeDao;

	@RequestMapping("/list")
	public String employee(Model model) {

		List<Employee> employeeList = employeeDao.findAllByOrderByFirstNameAsc();
		model.addAttribute("employee", employeeList);

		return "home";

	}

	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "employees-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") Integer id, Model model) {

		Employee employee = employeeService.getEmployee(id);
		model.addAttribute("employee", employee);

		return "employees-form";

	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees/list";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.addEmployee(emp);
		return "redirect:/employees/list";

	}
}
