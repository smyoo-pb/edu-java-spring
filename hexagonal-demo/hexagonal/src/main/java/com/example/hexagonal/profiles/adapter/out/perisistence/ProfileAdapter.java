package com.example.hexagonal.profiles.adapter.out.perisistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.jpa.entities.UserJpaEntity;
import com.example.hexagonal.infrastructure.jpa.repositories.UserJpaRepository;
import com.example.hexagonal.profiles.application.port.out.ProfileCreatePort;
import com.example.hexagonal.profiles.application.port.out.ProfileDeletePort;
import com.example.hexagonal.profiles.application.port.out.ProfileReadPort;
import com.example.hexagonal.profiles.application.port.out.ProfileUpdatePort;
import com.example.hexagonal.profiles.domain.Profile;

import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Component
@RequiredArgsConstructor
public class ProfileAdapter implements ProfileCreatePort, ProfileReadPort, ProfileUpdatePort, ProfileDeletePort {
    private final UserJpaRepository userJpaRepository;
    private final ProfileMapper userMapper;

    @Override
    public Profile create(Profile user) {
        UserJpaEntity entity = userJpaRepository.save(userMapper.toJpaEntity(user));
        return userMapper.toDomain(entity);
    }

    @Override
    public Profile findById(Long id) {
        Optional<UserJpaEntity> entity = userJpaRepository.findById(id);
        if (entity == null || !entity.isPresent()) {
            return null;
        }

        return userMapper.toDomain(entity.get());
    }

    @Override
    public List<Profile> findAll() {
        return userMapper.toDomain(userJpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public Profile update(Profile user) {
        UserJpaEntity entity = userJpaRepository.save(userMapper.toJpaEntity(user));
        return userMapper.toDomain(entity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return userJpaRepository.existsById(id);
    }
}
