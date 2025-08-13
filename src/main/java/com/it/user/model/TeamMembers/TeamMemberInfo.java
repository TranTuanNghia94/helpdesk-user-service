package com.it.user.model.TeamMembers;

import lombok.Data;

@Data
public class TeamMemberInfo {
    private String teamName;
    private String username;
    private String roleName;
    private String joinedAt;
    private String leftAt;
    private Boolean isActive;
}
