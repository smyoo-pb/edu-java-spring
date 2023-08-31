package com.example.hexagonal.profiles.adapter.out.perisistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.jpa.entities.ProfileJpaEntity;
import com.example.hexagonal.profiles.domain.Profile;

/**
 * 
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Component
public class ProfileMapper {
    public ProfileJpaEntity toJpaEntity(Profile profile) {
        return ProfileJpaEntity.builder()
                .email(profile.getEmail())
                .id(profile.getId()).build();
    }

    public Profile toDomain(ProfileJpaEntity profileJpaEntity) {
        return new Profile(
                profileJpaEntity.getId(),
                profileJpaEntity.getUser().getId(),
                profileJpaEntity.getApp(),
                profileJpaEntity.getName(),
                profileJpaEntity.getSpecies(),
                profileJpaEntity.getEmail(),
                profileJpaEntity.getBirth(),
                profileJpaEntity.getGender(),
                profileJpaEntity.getNickname(),
                profileJpaEntity.getCreatedAt(),
                profileJpaEntity.getUpdatedAt(),
                profileJpaEntity.getDeletedAt());
    }

    public List<Profile> toDomain(List<ProfileJpaEntity> profileJpaEntities) {
        return profileJpaEntities.stream().map(this::toDomain).toList();
    }
}
