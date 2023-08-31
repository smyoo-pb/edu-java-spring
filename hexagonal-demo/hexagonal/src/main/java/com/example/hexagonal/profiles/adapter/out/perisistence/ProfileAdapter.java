package com.example.hexagonal.profiles.adapter.out.perisistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.jpa.entities.ProfileJpaEntity;
import com.example.hexagonal.infrastructure.jpa.repositories.ProfileJpaRepository;
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
    private final ProfileJpaRepository profileJpaRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Profile create(Profile profile) {
        ProfileJpaEntity entity = profileJpaRepository.save(profileMapper.toJpaEntity(profile));
        return profileMapper.toDomain(entity);
    }

    @Override
    public Profile findById(Long id) {
        Optional<ProfileJpaEntity> entity = profileJpaRepository.findById(id);
        if (entity == null || !entity.isPresent()) {
            return null;
        }

        return profileMapper.toDomain(entity.get());
    }

    @Override
    public List<Profile> findAll() {
        return profileMapper.toDomain(profileJpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        profileJpaRepository.deleteById(id);
    }

    @Override
    public Profile update(Profile profile) {
        ProfileJpaEntity entity = profileJpaRepository.save(profileMapper.toJpaEntity(profile));
        return profileMapper.toDomain(entity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return profileJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return profileJpaRepository.existsById(id);
    }
}
