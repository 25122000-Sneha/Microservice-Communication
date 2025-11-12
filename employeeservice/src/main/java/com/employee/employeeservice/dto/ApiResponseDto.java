package com.employee.employeeservice.dto;

import com.employee.employeeservice.entity.Department;
import com.employee.employeeservice.entity.Employee;
import com.employee.employeeservice.entity.Organization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
    private Employee employee;
    private Department department;
    private Organization organization;
}
