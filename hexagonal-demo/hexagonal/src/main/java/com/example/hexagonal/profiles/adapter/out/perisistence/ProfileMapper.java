package com.example.hexagonal.profiles.adapter.out.perisistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.jpa.entities.UserJpaEntity;
import com.example.hexagonal.profiles.domain.Profile;

/**
 * 
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Component
public class ProfileMapper {
    public UserJpaEntity toJpaEntity(Profile user) {
        return UserJpaEntity.builder()
                .email(user.getEmail())
                .id(user.getId()).build();
    }

    public Profile toDomain(UserJpaEntity userJpaEntity) {
        return new Profile(userJpaEntity.getId(), userJpaEntity.getName(), userJpaEntity.getEmail());
    }

    public List<Profile> toDomain(List<UserJpaEntity> userJpaEntities) {
        return userJpaEntities.stream().map(this::toDomain).toList();
    }
}
