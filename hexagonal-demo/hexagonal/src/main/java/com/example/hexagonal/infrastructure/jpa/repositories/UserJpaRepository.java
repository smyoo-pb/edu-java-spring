package com.example.hexagonal.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonal.infrastructure.jpa.entities.UserJpaEntity;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

    UserJpaEntity findByUsername(String username);

    UserJpaEntity findBySnsId(String snsId);

    UserJpaEntity findByUserJpaEntity(UserJpaEntity userJpaEntity);

    UserJpaEntity findBySnsIdAndProvider(String snsId, String prodiver);

    UserJpaEntity findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
