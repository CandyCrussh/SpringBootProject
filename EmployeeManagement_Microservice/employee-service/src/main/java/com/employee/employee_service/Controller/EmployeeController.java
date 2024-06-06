package com.employee.employee_service.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_service.Entity.Employee;
import com.employee.employee_service.Services.EmployeeServices;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeServices empService;
	
	public EmployeeController(EmployeeServices empService) {
		this.empService = empService;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		LOGGER.info("Employee add: {}", emp);
		return new ResponseEntity<>(empService.addEmployee(emp), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id){
		LOGGER.info("Employee fetched id={}", id);
		return new ResponseEntity<>(empService.findbyIdEmployee(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		LOGGER.info("All Employee fetched");
		return new ResponseEntity<>(empService.findAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/department/{departmentId}")
	public ResponseEntity<List<Employee>> getbydepartment(@PathVariable Long departmentId){
		LOGGER.info("Employee fetched id={}", departmentId);
		return new ResponseEntity<>(empService.findByDepartment(departmentId), HttpStatus.OK);
	}

}
