package com.employee.employee_service.Services;

import java.util.List;
import java.util.Optional;

import com.employee.employee_service.Entity.Employee;

public interface EmployeeServices {

    Employee addEmployee(Employee employee) ;

    Optional<Employee> findbyIdEmployee(Long Id);

    List<Employee> findAllEmployee();

    List<Employee> findByDepartment(Long departmentId);

}
