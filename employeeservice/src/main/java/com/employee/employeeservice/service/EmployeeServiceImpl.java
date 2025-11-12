package com.employee.employeeservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.employeeservice.dto.ApiResponseDto;
import com.employee.employeeservice.entity.Department;
import com.employee.employeeservice.entity.Employee;
import com.employee.employeeservice.entity.Organization;
import com.employee.employeeservice.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    // @Autowired
    // private RestTemplate restTemplate;

    // @Autowired
    // private WebClient webClient;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @CircuitBreaker(name = "employeeservice", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(Long id){

        Employee reqdEmp = employeeRepository.findByEmployeeId(id).orElse(null);
        if(reqdEmp == null){
            return null;
        }
        // Department dept = restTemplate.getForObject("http://localhost:8000/department/" + reqdEmp.getDepartmentCode(), Department.class);

        // Department dept = webClient.get()
        //                 .uri("http://localhost:8000/department/" + reqdEmp.getDepartmentCode())
        //                 .retrieve()
        //                 .bodyToMono(Department.class)
        //                 .block();

        Department dept = apiClient.getDepartmentByCode(reqdEmp.getDepartmentCode());

        Organization org = organizationClient.getOrganizationByCode(reqdEmp.getOrganizationCode());

        ApiResponseDto responseDto = new ApiResponseDto();
        responseDto.setEmployee(reqdEmp);
        responseDto.setDepartment(dept);
        responseDto.setOrganization(org);
        return responseDto;
    }

    public ApiResponseDto getDefaultDepartment(Long id, Exception e){
        Employee reqdEmp = employeeRepository.findByEmployeeId(id).orElse(null);
        if(reqdEmp == null){
            return null;
        }

        Department dept = new Department();
        dept.setDepartmentCode("RD2001");
        dept.setDepartmentName("R&D");
        dept.setDepartmentDesc("R&D Department");

        ApiResponseDto responseDto = new ApiResponseDto();
        responseDto.setEmployee(reqdEmp);
        responseDto.setDepartment(dept);
        return responseDto;
    }
    
}
