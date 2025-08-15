package com.it.user.service.Users;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.it.user.entity.UserRolesEntity;
import com.it.user.entity.UsersEntity;
import com.it.user.mapper.UsersMapper;
import com.it.user.model.Departments.DepartmentInfo;
import com.it.user.model.Organizations.OrganizationInfo;
import com.it.user.model.Roles.RoleInfo;
import com.it.user.model.Users.Login;
import com.it.user.model.Users.UserInfo;
import com.it.user.repository.UserRolesRepository;
import com.it.user.repository.UsersRepository;
import com.it.user.service.DepartmentsService;
import com.it.user.service.OrganizationsService;
import com.it.user.service.RolesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository userRepo;
    private final UsersMapper userMapper;
    private final OrganizationsService organizationService;
    private final DepartmentsService departmentService;
    private final UserRolesRepository userRoleRepo;
    private final RolesService roleService;

    public UserInfo loginUser(Login login) {
        log.info("Logging in user: {}", login.getUsername());
        try {
            UsersEntity user = validateAndGetUser(login.getUsername());
            validateUserStatus(user);
            validatePassword(user, login.getPassword());

            log.info("Successfully logged in user: {}", login.getUsername());
            return buildUserInfo(user);
        } catch (Exception e) {
            log.error("Error logging in user: {}", login.getUsername(), e);
            throw new RuntimeException("Error logging in user: " + e.getMessage());
        }
    }

    public UserInfo getUserById(UUID id) {
        log.info("Fetching user by ID: {}", id);
        try {
            UsersEntity user = userRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            log.info("Successfully retrieved user - ID: {}, Username: {}", id, user.getUsername());
            return buildUserInfo(user);
        } catch (Exception e) {
            log.error("Error fetching user by ID: {}", id, e);
            throw new RuntimeException("Error fetching user by ID: " + e.getMessage());
        }
    }

    private UsersEntity validateAndGetUser(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private void validateUserStatus(UsersEntity user) {
        if (!"ACTIVE".equals(user.getStatus())) {
            log.warn("User is not active: {}", user.getUsername());
            throw new RuntimeException("User is not active");
        }
    }

    private void validatePassword(UsersEntity user, String password) {
        // String aaa = BCrypt.hashpw(password, BCrypt.gensalt());

        if (!BCrypt.checkpw(password, user.getPasswordHash())) {
            log.warn("Invalid password for user: {}", user.getUsername());
            throw new RuntimeException("Invalid password");
        }
    }

    private UserInfo buildUserInfo(UsersEntity user) {
        OrganizationInfo organization = organizationService.getOrganizationById(user.getOrganizationId());
        if (organization == null) {
            log.warn("Organization not found with ID: {}", user.getOrganizationId());
            throw new RuntimeException("Organization not found");
        }

        DepartmentInfo department = departmentService.getDepartmentById(user.getDepartmentId());
        if (department == null) {
            log.warn("Department not found with ID: {}", user.getDepartmentId());
            throw new RuntimeException("Department not found");
        }

        UserRolesEntity userRole = userRoleRepo.findByUserId(user.getId());
        if (userRole == null) {
            log.warn("User role not found with ID: {}", user.getId());
            throw new RuntimeException("User role not found");
        }

        RoleInfo role = roleService.getRoleById(userRole.getRoleId());
        if (role == null) {
            log.warn("Role not found with ID: {}", userRole.getRoleId());
            throw new RuntimeException("Role not found");
        }

        return userMapper.mapToUserInfo(user, organization, department, role);
    }
}
