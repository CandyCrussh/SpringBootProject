package com.employee.department_service.Services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.department_service.Entities.Employee;

@FeignClient(url = "http://localhost:8082", value = "Employee-Client")
//@FeignClient(url = "EMPLOYEE-SERVICE", value = "Employee-Client")
public interface EmployeeClient {

    @GetMapping("/employee/department/{departmentId}")
    List<Employee> getEmp(@PathVariable Long departmentId);

}
