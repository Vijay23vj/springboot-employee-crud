package org.jsp.employee_crud.controller;

import org.jsp.employee_crud.dto.Employee;
import org.jsp.employee_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String loadhome() {
		return "home.html";
	}
	@GetMapping("/add-employee")
	public String addEmployee(ModelMap map) {
		map.put("add", "add");
		return "home.html";
	}
	
	@PostMapping("/add-employee")
	public String addEmployee(Employee employee,ModelMap map) {
		employeeRepository.save(employee);
		map.put("success", "Record Added Successfully");
		return "home.html";
	}
	
	@GetMapping("/fetch-employee")
	public String fetchEmployee(ModelMap map) {
		map.put("records", employeeRepository.findAll());
		return "home.html";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id,ModelMap map) {
		Employee employee=employeeRepository.findById(id).orElseThrow();
		map.put("emp", employee);
		map.put("edit","edit");
		return "home.html";
	}
	@PostMapping("/update-employee")
	public String updateEmployee(Employee employee,ModelMap map) {
		employeeRepository.save(employee);
		map.put("success", "Record Updated Successfully");
		return "home.html";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam int id,ModelMap map) {
		employeeRepository.deleteById(id);
		map.put("success", "Record Deleted Successfully");
		return "home.html";
	}
}
