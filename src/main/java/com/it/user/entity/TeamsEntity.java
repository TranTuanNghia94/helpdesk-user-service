package com.it.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

import jakarta.persistence.Column;

@Entity
@Table(name = "teams")
@Data
public class TeamsEntity extends BaseEntity {
    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "team_lead_id")
    private UUID teamLeadId;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "specializations", columnDefinition = "JSONB")
    private Object specializations;

    @Column(name = "work_schedule", columnDefinition = "JSONB")
    private Object workSchedule;

    @Column(name = "escalation_rules", columnDefinition = "JSONB")
    private Object escalationRules;
}
