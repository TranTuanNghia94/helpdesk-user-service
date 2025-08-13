package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.UserRolesEntity;
import com.it.user.model.UserRoles.UserRoleInfo;
import com.it.user.model.Users.UserInfo;
import com.it.user.model.Roles.RoleInfo;
import com.it.user.model.Organizations.OrganizationInfo;

@Component
public class UserRolesMapper {
    public UserRoleInfo mapToUserRoleInfo(UserRolesEntity userRole, UserInfo user, RoleInfo role, OrganizationInfo organization) {
        if (userRole == null) {
            return null;
        }
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userRoleInfo.setUsername(user.getUsername());
        userRoleInfo.setRoleName(role.getName());
        userRoleInfo.setOrganizationName(organization.getName());
        userRoleInfo.setAssignedAt(userRole.getAssignedAt().toString());
        userRoleInfo.setExpiresAt(userRole.getExpiresAt().toString());
        userRoleInfo.setAssignedBy(userRole.getAssignedBy().toString());
        return userRoleInfo;
    }
}
