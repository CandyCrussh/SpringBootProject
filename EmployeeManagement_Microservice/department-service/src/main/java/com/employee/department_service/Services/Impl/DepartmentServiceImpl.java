package com.employee.department_service.Services.Impl;

import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employee.department_service.Entities.Department;
import com.employee.department_service.Repository.DepartmentRepo;
import com.employee.department_service.Services.DepartmentServices;
import com.employee.department_service.Services.EmployeeClient;

@Service
public class DepartmentServiceImpl implements DepartmentServices {

    private DepartmentRepo repo;

    private EmployeeClient empClient;

    public DepartmentServiceImpl(DepartmentRepo repo, EmployeeClient empClient){
        this.repo = repo;
        this.empClient = empClient;
    }

    @Override
    public Department addDepartment(Department dp) {
        return repo.save(dp);
    }

    @Override
    public Department findbyIddep(Long Id) {
        Department getDep =  repo.findById(Id).orElseThrow(()-> new RuntimeException("Data not found"));
        getDep.setEmp(empClient.getEmp(getDep.getId()));
        return getDep;
    }

    @Override
    public List<Department> findAlldep() {
        List<Department> newDepList = repo.findAll();
        newDepList.stream().map(e->{
            e.setEmp(empClient.getEmp(e.getId()));
            return e;
        }).collect(Collectors.toList());
        return repo.findAll();
    }

    @Override
    public void deleteByIddep(Long Id) {
        repo.deleteById(Id);
    }
}
