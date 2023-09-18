package com.example.hexagonal.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonal.infrastructure.jpa.entities.ProfileJpaEntity;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/30
 */
public interface ProfileJpaRepository extends JpaRepository<ProfileJpaEntity, Long> {
    boolean existsByEmail(String email);
}
