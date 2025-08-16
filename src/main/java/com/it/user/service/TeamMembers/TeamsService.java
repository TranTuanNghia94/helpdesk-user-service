package com.it.user.service.TeamMembers;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.it.user.entity.TeamsEntity;
import com.it.user.mapper.TeamsMapper;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.model.Teams.TeamInfo;
import com.it.user.repository.TeamsRepository;
import com.it.user.service.Organizations.OrganizationsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeamsService {
    private final TeamsRepository teamRepo;
    private final TeamsMapper teamMapper;
    private final OrganizationsService organizationService;

    public TeamsService(TeamsRepository teamRepo, TeamsMapper teamMapper, OrganizationsService organizationService) {
        this.teamRepo = teamRepo;
        this.teamMapper = teamMapper;
        this.organizationService = organizationService;
    }

    public TeamInfo getTeamById(UUID id) {
        log.info("Fetching team by ID: {}", id);
        try {
            TeamsEntity team = teamRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
            
            log.info("Successfully retrieved team - ID: {}, Name: {}", id, team.getName());
            return buildTeamInfo(team);
        } catch (Exception e) {
            log.error("Error fetching team by ID: {}", id, e);  
            throw new RuntimeException("Error fetching team by ID: " + e.getMessage());
        }
    }

    public TeamInfo getTeamByCode(String code) {
        log.info("Fetching team by code: {}", code);
        try {
            TeamsEntity team = teamRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Team not found"));
            
            log.info("Successfully retrieved team - Code: {}, Name: {}", code, team.getName());
            return buildTeamInfo(team);
        } catch (Exception e) {
            log.error("Error fetching team by code: {}", code, e); 
            throw new RuntimeException("Error fetching team by code: " + e.getMessage());
        }
    }

    private TeamInfo buildTeamInfo(TeamsEntity team) {
        OrganizationInfo organization = organizationService.getOrganizationById(team.getOrganizationId());
        if (organization == null) {
            log.warn("Organization not found with ID: {}", team.getOrganizationId());
            throw new RuntimeException("Organization not found");
        }
        
        return teamMapper.mapToTeamInfo(team, organization);
    }
}
