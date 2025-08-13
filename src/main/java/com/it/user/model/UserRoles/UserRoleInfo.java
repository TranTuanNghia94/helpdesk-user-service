package com.it.user.model.UserRoles;

import lombok.Data;

@Data
public class UserRoleInfo {
    private String username;
    private String roleName;
    private String organizationName;
    private String assignedAt;
    private String expiresAt;
    private String assignedBy;
}
