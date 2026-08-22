package com.internship.infosys.profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository
        extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByUserId(Long userId);

    boolean existsByUserId(Long userId);

    Optional<ProfileEntity> findByEmployeeId(
        String employeeId
    );
}