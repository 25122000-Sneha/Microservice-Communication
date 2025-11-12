package com.employee.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeservice.dto.ApiResponseDto;
import com.employee.employeeservice.entity.Employee;
import com.employee.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
        ApiResponseDto res = employeeService.getEmployeeById(id);
        //Employee emp = res.getEmployee();
        if(res!=null && res.getEmployee()!=null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
