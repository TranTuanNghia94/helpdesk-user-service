package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.OrganizationsEntity;
import com.it.user.model.Organizations.OrganizationInfo;

@Component
public class OrganizationsMapper {

    public OrganizationInfo mapToOrganizationInfo(OrganizationsEntity organization) {
        if (organization == null) {
            return null;
        }
        
        OrganizationInfo organizationInfo = new OrganizationInfo();
        
        // Map inherited fields from GeneralInfo
        organizationInfo.setId(organization.getId() != null ? organization.getId().toString() : null);
        organizationInfo.setName(organization.getName());
        organizationInfo.setCode(organization.getCode());
        organizationInfo.setDescription(organization.getDescription());
        organizationInfo.setStatus(organization.getStatus());
        
        // Map organization-specific fields
        organizationInfo.setParentOrganizationId(organization.getParentOrganizationId() != null ? 
            organization.getParentOrganizationId().toString() : null);
        organizationInfo.setAddress(organization.getAddress());
        organizationInfo.setPhone(organization.getPhone());
        organizationInfo.setEmail(organization.getEmail());
        organizationInfo.setTimezone(organization.getTimezone());
        organizationInfo.setSettings(organization.getSettings());

        return organizationInfo;
    }
}
