package com.it.user.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data
public class DepartmentsEntity extends BaseEntity {
    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "parent_department_id")
    private UUID parentDepartmentId;

    @Column(name = "manager_id")
    private UUID managerId;

    @Column(name="cost_center", length = 50)    
    private String costCenter;

    @Column(name="location", length=255)
    private String location;
}
