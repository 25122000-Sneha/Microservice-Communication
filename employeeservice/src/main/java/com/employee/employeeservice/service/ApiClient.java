package com.employee.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.employeeservice.entity.Department;


@FeignClient(name = "departmentservice")
public interface ApiClient {
    @GetMapping("/department/{code}")
    public Department getDepartmentByCode(@PathVariable String code);

}
