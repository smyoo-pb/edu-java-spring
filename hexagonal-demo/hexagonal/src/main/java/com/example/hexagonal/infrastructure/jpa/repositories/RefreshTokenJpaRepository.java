package com.example.hexagonal.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonal.infrastructure.jpa.entities.RefreshTokenJpaEntity;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
public interface RefreshTokenJpaRepository extends JpaRepository<RefreshTokenJpaEntity, Long> {

}
