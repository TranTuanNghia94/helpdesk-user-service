package com.it.user.service.Departments;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.it.user.entity.DepartmentsEntity;
import com.it.user.mapper.DepartmentsMapper;
import com.it.user.model.Departments.DepartmentInfo;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.repository.DepartmentsRepository;
import com.it.user.service.Organizations.OrganizationsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentsService {

    private final DepartmentsRepository departmentRepo;
    private final OrganizationsService organizationService;
    private final DepartmentsMapper departmentMapper;

    public DepartmentsService(DepartmentsRepository departmentRepo, OrganizationsService organizationService,
            DepartmentsMapper departmentMapper) {
        this.departmentRepo = departmentRepo;
        this.organizationService = organizationService;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentInfo getDepartmentById(UUID id) {
        log.info("Fetching department by ID: {}", id);
        try {
            DepartmentsEntity department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
            
            log.info("Successfully retrieved department - ID: {}, Name: {}", id, department.getName());
            return buildDepartmentInfo(department);
        } catch (Exception e) {
            log.error("Error fetching department by ID: {}", id, e);
            throw new RuntimeException("Error fetching department by ID: " + e.getMessage());
        }
    }

    public DepartmentInfo getDepartmentByCode(String code) {
        log.info("Fetching department by code: {}", code);
        try {
            DepartmentsEntity department = departmentRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Department not found"));
            
            log.info("Successfully retrieved department - Code: {}, Name: {}", code, department.getName());
            return buildDepartmentInfo(department);
        } catch (Exception e) {
            log.error("Error fetching department by code: {}", code, e);
            throw new RuntimeException("Error fetching department by code: " + e.getMessage());
        }
    }

    private DepartmentInfo buildDepartmentInfo(DepartmentsEntity department) {
        OrganizationInfo organization = organizationService.getOrganizationById(department.getOrganizationId());
        if (organization == null) {
            log.warn("Organization not found with ID: {}", department.getOrganizationId());
            throw new RuntimeException("Organization not found");
        }

        return departmentMapper.mapToDepartmentInfo(department, organization);
    }
}
