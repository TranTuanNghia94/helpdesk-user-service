package com.it.user.model.Roles;

import com.it.user.model.General.GeneralInfo;

import lombok.Data;

@Data
public class RoleInfo extends GeneralInfo {
    private String organizationName;
    private Boolean isSystemRole;
    private Object permissions;
}
