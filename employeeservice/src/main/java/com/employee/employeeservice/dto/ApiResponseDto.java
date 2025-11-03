package com.employee.employeeservice.dto;

import com.employee.employeeservice.entity.Department;
import com.employee.employeeservice.entity.Employee;

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
}
