package com.employee.department_service.Controller;

import java.util.List;
// import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.department_service.Entities.Department;
import com.employee.department_service.Services.DepartmentServices;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	private DepartmentServices depServices;
	
	public DepartmentController(DepartmentServices depServices) {
		this.depServices = depServices;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department dp){
		LOGGER.info("Department add: {}", dp);
		return new ResponseEntity<>(depServices.addDepartment(dp), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable Long id){
		LOGGER.info("Department Find id: {}", id);
		return new ResponseEntity<>(depServices.findbyIddep(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment(){
		LOGGER.info("Department All");
		return new ResponseEntity<>(depServices.findAlldep(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteByIdDepartment(@PathVariable Long id){
		LOGGER.info("Department delete id: {}", id);
		depServices.deleteByIddep(id);
	}
	
	
}
