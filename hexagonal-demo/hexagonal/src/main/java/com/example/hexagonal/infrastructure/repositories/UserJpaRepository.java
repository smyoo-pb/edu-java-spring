package com.example.hexagonal.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hexagonal.infrastructure.entities.UserJpaEntity;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

    UserJpaEntity findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
