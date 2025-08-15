package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.UsersEntity;
import com.it.user.model.Users.UserInfo;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.model.Departments.DepartmentInfo;

@Component
public class UsersMapper {
    public UserInfo mapToUserInfo(UsersEntity user, OrganizationInfo organization, DepartmentInfo department) {
        if (user == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setOrganizationName(organization.getName());
        userInfo.setDepartmentName(department.getName());
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setMiddleName(user.getMiddleName());
        userInfo.setDisplayName(user.getDisplayName());
        userInfo.setEmployeeId(user.getEmployeeId() != null ? user.getEmployeeId().toString() : null);
        userInfo.setPhone(user.getPhone());
        userInfo.setMobile(user.getMobile());
        userInfo.setJobTitle(user.getJobTitle());
        userInfo.setManagerId(user.getManagerId() != null ? user.getManagerId().toString() : null);
        userInfo.setLocation(user.getLocation());
        userInfo.setTimezone(user.getTimezone());
        userInfo.setLanguage(user.getLanguage());
        userInfo.setAvatarUrl(user.getAvatarUrl());
        userInfo.setLastLoginAt(user.getLastLoginAt() != null ? user.getLastLoginAt().toString() : null);
        userInfo.setSkills(user.getSkills());
        userInfo.setWorkSchedule(user.getWorkSchedule());
        userInfo.setPreferences(user.getPreferences());
        userInfo.setStatus(user.getStatus());
        
        return userInfo;
    }
}
