package com.it.user.service.Roles;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.it.user.entity.RolesEntity;
import com.it.user.mapper.RolesMapper;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.model.Roles.RoleInfo;
import com.it.user.repository.RolesRepository;
import com.it.user.service.Organizations.OrganizationsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolesService {
    private final RolesRepository roleRepo;
    private final RolesMapper roleMapper;
    private final OrganizationsService organizationService;

    public RolesService(RolesRepository roleRepo, RolesMapper roleMapper, OrganizationsService organizationService) {
        this.roleRepo = roleRepo;
        this.roleMapper = roleMapper;
        this.organizationService = organizationService;
    }

    public RoleInfo getRoleById(UUID id) {
        log.info("Fetching role by ID: {}", id);
        try {
            RolesEntity role = roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
            
            log.info("Successfully retrieved role - ID: {}, Name: {}", id, role.getName());
            return buildRoleInfo(role);
        } catch (Exception e) {
            log.error("Error fetching role by ID: {}", id, e);
            throw new RuntimeException("Error fetching role by ID: " + e.getMessage());
        }
    }

    public RoleInfo getRoleByCode(String code) {
        log.info("Fetching role by code: {}", code);
        try {
            RolesEntity role = roleRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Role not found"));
            
            log.info("Successfully retrieved role - Code: {}, Name: {}", code, role.getName());
            return buildRoleInfo(role);
        } catch (Exception e) {
            log.error("Error fetching role by code: {}", code, e);
            throw new RuntimeException("Error fetching role by code: " + e.getMessage());
        }
    }

    private RoleInfo buildRoleInfo(RolesEntity role) {
        OrganizationInfo organization = organizationService.getOrganizationById(role.getOrganizationId());
        if (organization == null) {
            log.warn("Organization not found with ID: {}", role.getOrganizationId());
            throw new RuntimeException("Organization not found");
        }

        return roleMapper.mapToRoleInfo(role, organization);
    }
}
