package com.it.user.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "organization_id", nullable = false)
    private UUID organizationId;

    @Column(name = "department_id")
    private UUID departmentId;

    @Column(name = "username", nullable = false, length = 100, unique = true)
    private String username;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "display_name", length = 255)
    private String displayName;

    @Column(name = "employee_id", length = 50)
    private String employeeId;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "mobile", length = 50)
    private String mobile;

    @Column(name = "job_title", length = 100)
    private String jobTitle;

    @Column(name = "manager_id")
    private UUID managerId;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "timezone", length = 100)
    private String timezone;

    @Column(name = "language", length = 10)
    private String language;

    @Column(name = "avatar_url", length = 500)
    private String avatarUrl;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @Column(name = "password_changed_at")
    private Instant passwordChangedAt;

    @Column(name = "must_change_password")
    private Boolean mustChangePassword;

    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttempts;

    @Column(name = "locked_until")
    private Instant lockedUntil;

    @Column(name = "is_mfa_enabled")
    private Boolean isMfaEnabled;

    @Column(name = "mfa_secret", length = 255)
    private String mfaSecret;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "preferences", columnDefinition = "JSONB")
    private Object preferences;

    @Column(name = "skills", columnDefinition = "JSONB")
    private Object skills;

    @Column(name = "work_schedule", columnDefinition = "JSONB")
    private Object workSchedule;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;
}
