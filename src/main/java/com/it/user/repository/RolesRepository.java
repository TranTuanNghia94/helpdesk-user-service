package com.it.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.it.user.entity.RolesEntity;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, UUID> {

    Optional<RolesEntity> findByCode(String code);

}
