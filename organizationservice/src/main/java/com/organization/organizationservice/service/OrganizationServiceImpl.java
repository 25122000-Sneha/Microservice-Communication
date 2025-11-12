package com.organization.organizationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.organizationservice.entity.Organization;
import com.organization.organizationservice.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization addOrganization(Organization organization){
        return organizationRepository.save(organization);
    }

    public Organization getOrganizationByCode(String code){
        return organizationRepository.findByOrganizationCode(code).orElse(null);
    }
    
}
