package com.employee.employeeservice.service;

import com.employee.employeeservice.dto.ApiResponseDto;
import com.employee.employeeservice.entity.Employee;

public interface EmployeeService {
    
    public Employee addEmployee(Employee employee);

    public ApiResponseDto getEmployeeById(Long id);
}
