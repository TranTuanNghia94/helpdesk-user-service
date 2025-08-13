package com.it.user.mapper;

import org.springframework.stereotype.Component;

import com.it.user.entity.TeamMembersEntity;
import com.it.user.model.TeamMembers.TeamMemberInfo;
import com.it.user.model.Teams.TeamInfo;
import com.it.user.model.Users.UserInfo;
import com.it.user.model.Roles.RoleInfo;

@Component
public class TeamMembersMapper {
    public TeamMemberInfo mapToTeamMemberInfo(TeamMembersEntity teamMember, TeamInfo team, UserInfo user, RoleInfo role) {
        if (teamMember == null) {
            return null;
        }
        TeamMemberInfo teamMemberInfo = new TeamMemberInfo();
        teamMemberInfo.setTeamName(team.getName());
        teamMemberInfo.setUsername(user.getUsername());
        teamMemberInfo.setRoleName(role.getName());
        teamMemberInfo.setJoinedAt(teamMember.getJoinedAt().toString());
        teamMemberInfo.setLeftAt(teamMember.getLeftAt().toString());
        teamMemberInfo.setIsActive(teamMember.getIsActive());
        return teamMemberInfo;
    }
}
