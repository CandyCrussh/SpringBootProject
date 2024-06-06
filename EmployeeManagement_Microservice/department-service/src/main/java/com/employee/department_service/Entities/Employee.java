package com.employee.department_service.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// public record Employee(Long id, Long departmentId, String name, int age, String position) {

// }

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
    
}