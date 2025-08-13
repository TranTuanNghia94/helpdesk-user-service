package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.TeamsEntity;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.model.Teams.TeamInfo;

@Component
public class TeamsMapper {
    public TeamInfo mapToTeamInfo(TeamsEntity team, OrganizationInfo organization) {
        if (team == null) {
            return null;
        }
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setId(team.getId().toString());
        teamInfo.setName(team.getName());
        teamInfo.setCode(team.getCode());
        teamInfo.setDescription(team.getDescription());
        teamInfo.setStatus(team.getStatus());
        teamInfo.setOrganizationName(organization.getName());
        teamInfo.setTeamLeadId(team.getTeamLeadId().toString());
        teamInfo.setEmail(team.getEmail());
        teamInfo.setSpecializations(team.getSpecializations());
        teamInfo.setWorkSchedule(team.getWorkSchedule());
        teamInfo.setEscalationRules(team.getEscalationRules());

        return teamInfo;
    }
}
