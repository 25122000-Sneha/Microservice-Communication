package com.employee.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.employeeservice.entity.Organization;

//@FeignClient(url = "http://localhost:8002/", value = "organizationClient")
@FeignClient(name = "organizationservice")
public interface OrganizationClient {

    @GetMapping("/organization/{code}")
    public Organization getOrganizationByCode(@PathVariable String code);
} 