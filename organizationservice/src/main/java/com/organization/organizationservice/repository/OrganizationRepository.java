package com.organization.organizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.organizationservice.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    
    public Optional<Organization> findByOrganizationCode(String code);
    
}
