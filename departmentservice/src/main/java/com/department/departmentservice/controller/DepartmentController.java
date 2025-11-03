package com.department.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.departmentservice.entity.Department;
import com.department.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Department> getDepartmentByCode(@PathVariable String code){

        Department requiredDept = departmentService.getDepartmentByCode(code);
        if(requiredDept!=null){
            return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
        }
        else
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    
}
