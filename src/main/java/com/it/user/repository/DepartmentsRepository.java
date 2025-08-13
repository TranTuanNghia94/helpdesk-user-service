package com.it.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.it.user.entity.DepartmentsEntity;

@Repository
public interface DepartmentsRepository extends JpaRepository<DepartmentsEntity, UUID> {

    Optional<DepartmentsEntity> findByCode(String code);

}
