package com.it.user.model.Teams;

import com.it.user.model.General.GeneralInfo;

import lombok.Data;

@Data
public class TeamInfo extends GeneralInfo {
    private String organizationName;
    private String teamLeadId;
    private String email;
    private Object specializations;
    private Object workSchedule;
    private Object escalationRules;
}
