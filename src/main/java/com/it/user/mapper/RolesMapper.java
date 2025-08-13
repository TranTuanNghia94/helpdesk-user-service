package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.RolesEntity;
import com.it.user.model.Roles.RoleInfo;
import com.it.user.model.Organizations.OrganizationInfo;

@Component
public class RolesMapper {
    public RoleInfo mapToRoleInfo(RolesEntity role, OrganizationInfo organization) {
        if (role == null) {
            return null;
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(role.getId().toString());
        roleInfo.setName(role.getName());
        roleInfo.setCode(role.getCode());
        roleInfo.setDescription(role.getDescription());
        roleInfo.setStatus(role.getStatus());
        roleInfo.setOrganizationName(organization.getName());
        roleInfo.setIsSystemRole(role.getIsSystemRole());
        roleInfo.setPermissions(role.getPermissions());
        
        return roleInfo;
    }
}
