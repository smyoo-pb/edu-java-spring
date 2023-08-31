package com.example.hexagonal.infrastructure.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonal.infrastructure.jpa.entities.AccessTokenJpaEntity;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/31
 */
public interface AccessTokenJpaRepository extends JpaRepository<AccessTokenJpaEntity, Long> {

}
