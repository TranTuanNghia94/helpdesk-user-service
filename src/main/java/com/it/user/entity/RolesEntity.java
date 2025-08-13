package com.it.user.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class RolesEntity extends BaseEntity {
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    
    @Column(name = "permissions", columnDefinition = "JSONB")
    private Object permissions;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "is_system_role")
    private Boolean isSystemRole;
}
