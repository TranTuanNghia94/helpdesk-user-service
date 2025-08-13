package com.it.user.model.Organizations;

import com.it.user.model.General.GeneralInfo;

import lombok.Data;

@Data
public class OrganizationInfo extends GeneralInfo {
    private String parentOrganizationId;
    private String address;
    private String phone;
    private String email;
    private String timezone;
    private Object settings;
}
