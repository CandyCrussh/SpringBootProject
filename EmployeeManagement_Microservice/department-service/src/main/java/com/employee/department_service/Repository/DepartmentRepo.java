package com.employee.department_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.department_service.Entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{
}
