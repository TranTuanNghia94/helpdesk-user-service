package com.it.user.service.Organizations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.repository.OrganizationsRepository;
import com.it.user.entity.OrganizationsEntity;
import com.it.user.mapper.OrganizationsMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrganizationsService {
    private final OrganizationsRepository orgRepo;
    private final OrganizationsMapper orgMapper;

    public OrganizationsService(OrganizationsRepository orgRepo, OrganizationsMapper orgMapper) {
        this.orgRepo = orgRepo;
        this.orgMapper = orgMapper;
    }

    public OrganizationInfo getOrganizationById(UUID id) {
        log.info("Fetching organization by ID: {}", id);
        
        try {
            OrganizationsEntity organization = orgRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
            
            log.info("Successfully retrieved organization - ID: {}, Name: {}", 
                     id, organization.getName());

            return orgMapper.mapToOrganizationInfo(organization);
        } catch (RuntimeException e) {
            log.error("Business exception while fetching organization with ID: {}", id, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching organization with ID: {}", id, e);
            throw new RuntimeException("Error getting organization by id: " + e.getMessage());
        }
    }

    public OrganizationInfo getOrganizationByCode(String code) {
        log.info("Fetching organization by code: {}", code);
        
        try {
            OrganizationsEntity organization = orgRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
            
            log.info("Successfully retrieved organization - Code: {}, Name: {}", 
                     code, organization.getName());

            return orgMapper.mapToOrganizationInfo(organization);
        } catch (RuntimeException e) {
            log.error("Business exception while fetching organization with code: {}", code, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching organization with code: {}", code, e);
            throw new RuntimeException("Error getting organization by code: " + e.getMessage());
        }
    }
}
