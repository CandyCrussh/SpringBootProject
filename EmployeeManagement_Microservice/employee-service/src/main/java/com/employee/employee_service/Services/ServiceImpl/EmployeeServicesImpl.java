package com.employee.employee_service.Services.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.employee_service.Entity.Employee;
import com.employee.employee_service.Repository.EmployeeRepo;
import com.employee.employee_service.Services.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices{

    private EmployeeRepo empRepo;

    public EmployeeServicesImpl(EmployeeRepo empRepo){
        this.empRepo=empRepo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Optional<Employee> findbyIdEmployee(Long Id) {
        return Optional.of(empRepo.findById(Id).orElseThrow(()-> new RuntimeException("Not found")));
    }

    @Override
    public List<Employee> findAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return empRepo.findByDepartmentId(departmentId);
    }
    
}
