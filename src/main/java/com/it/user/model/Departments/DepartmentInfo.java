package com.it.user.model.Departments;

import com.it.user.model.General.GeneralInfo;

import lombok.Data;

@Data
public class DepartmentInfo extends GeneralInfo {
    private String organizationName;
    private String parentDepartmentId;
    private String managerId;
    private String costCenter;
    private String location;
}
