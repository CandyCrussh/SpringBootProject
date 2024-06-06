package com.employee.department_service.Services;

import java.util.List;
// import java.util.Optional;

import com.employee.department_service.Entities.Department;

public interface DepartmentServices {
    
    Department addDepartment(Department dp);
    
    Department findbyIddep(Long Id);

    List<Department> findAlldep();

    void deleteByIddep(Long Id);
}
