package com.it.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.it.user.entity.TeamMembersEntity;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembersEntity, UUID> {

}
