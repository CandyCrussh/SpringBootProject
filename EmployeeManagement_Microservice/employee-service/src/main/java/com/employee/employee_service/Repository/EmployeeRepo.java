package com.employee.employee_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employee_service.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	List<Employee> findByDepartmentId(Long departmentId);

// 	private List<Employee> emp = new ArrayList<>();
	
// 	public Employee addEmployee(Employee employee) {
// 		emp.add(employee);
// 		return employee;
// 	}
	
// 	public Employee findbyIdEmployee(Long Id) {
// 		return emp.stream().filter(e->e.id().equals(Id)).findFirst().orElseThrow();
// 	}
	
// 	public List<Employee> findAllEmployee(){
// 		return emp;
// 	}
	
// 	public List<Employee> findByDepartment(Long departmentId) {
// 		return emp.stream().filter(dp->dp.departmentId().equals(departmentId)).toList();
// 	}
}

