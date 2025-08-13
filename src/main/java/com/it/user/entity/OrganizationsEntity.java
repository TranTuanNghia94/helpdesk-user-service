package com.it.user.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "organizations")
@Data
public class OrganizationsEntity extends BaseEntity {
    @Column(name = "code", nullable = false, length = 50, unique = true)
    private String code;

    @Column(name = "parent_organization_id")
    private UUID parentOrganizationId;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "timezone", length = 100)
    private String timezone;

    @Column(name = "settings", columnDefinition = "JSONB")
    private Object settings;
}
