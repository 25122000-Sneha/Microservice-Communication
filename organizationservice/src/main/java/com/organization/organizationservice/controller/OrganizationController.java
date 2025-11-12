package com.organization.organizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.organizationservice.entity.Organization;
import com.organization.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<Organization> addOrganization(@RequestBody Organization organization){
        return new ResponseEntity<>(organizationService.addOrganization(organization), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Organization> getOrganizationByCode(@PathVariable String code){
        Organization organization = organizationService.getOrganizationByCode(code);
        if(organization!=null){
            return new ResponseEntity<>(organization, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
