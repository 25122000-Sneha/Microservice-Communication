package com.organization.organizationservice.service;

import com.organization.organizationservice.entity.Organization;

public interface OrganizationService {
    public Organization addOrganization(Organization organization);
    public Organization getOrganizationByCode(String code);
}
