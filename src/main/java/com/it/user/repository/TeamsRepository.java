package com.it.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.it.user.entity.TeamsEntity;

@Repository
public interface TeamsRepository extends JpaRepository<TeamsEntity, UUID> {

    Optional<TeamsEntity> findByCode(String code);

}
