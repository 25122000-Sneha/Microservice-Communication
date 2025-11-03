package com.department.departmentservice.service;

import com.department.departmentservice.entity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public Department getDepartmentByCode(String code);
    
}
