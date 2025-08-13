package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.DepartmentsEntity;
import com.it.user.model.Departments.DepartmentInfo;
import com.it.user.model.Organizations.OrganizationInfo;

@Component
public class DepartmentsMapper {
    public DepartmentInfo mapToDepartmentInfo(DepartmentsEntity department, OrganizationInfo organization) {
        if (department == null) {
            return null;
        }
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setId(department.getId().toString());
        departmentInfo.setCode(department.getCode());
        departmentInfo.setName(department.getName());
        departmentInfo.setParentDepartmentId(department.getParentDepartmentId().toString());
        departmentInfo.setManagerId(department.getManagerId().toString());
        departmentInfo.setCostCenter(department.getCostCenter());
        departmentInfo.setLocation(department.getLocation());
        departmentInfo.setDescription(department.getDescription());
        departmentInfo.setStatus(department.getStatus());
        departmentInfo.setOrganizationName(organization.getName());
        
        return departmentInfo;
    }
}
