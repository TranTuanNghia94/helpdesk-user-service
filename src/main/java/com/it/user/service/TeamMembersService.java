// package com.it.user.service;

// import org.springframework.stereotype.Service;

// import com.it.user.mapper.TeamMembersMapper;
// import com.it.user.model.TeamMembers.TeamMemberInfo;
// import com.it.user.repository.TeamMembersRepository;

// import lombok.extern.slf4j.Slf4j;

// @Service
// @Slf4j
// public class TeamMembersService {
//     private final TeamMembersRepository teamMemberRepo;
//     private final TeamMembersMapper teamMemberMapper;
//     private final TeamsService teamService;
//     private final UsersService userService;
//     private final RolesService roleService;

//     public TeamMembersService(TeamMembersRepository teamMemberRepo, TeamMembersMapper teamMemberMapper,
//             TeamsService teamService, UsersService userService, RolesService roleService) {
//         this.teamMemberRepo = teamMemberRepo;
//         this.teamMemberMapper = teamMemberMapper;
//         this.teamService = teamService;
//         this.userService = userService;
//         this.roleService = roleService;
//     }

//     public TeamMemberInfo getTeamMemberById(UUID id) {
//         log.info("Fetching team member by ID: {}", id);
//         try {
//             TeamMembersEntity teamMember = teamMemberRepo.findById(id).orElse(null);
//         }
//     }
// }
