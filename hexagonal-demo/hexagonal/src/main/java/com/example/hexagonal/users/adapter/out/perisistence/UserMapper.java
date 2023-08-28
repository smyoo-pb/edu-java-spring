package com.example.hexagonal.users.adapter.out.perisistence;

import org.springframework.stereotype.Component;

import com.example.hexagonal.infrastructure.entities.UserJpaEntity;
import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Component
public class UserMapper {
    public UserJpaEntity toJpaEntity(User user) {
        UserJpaEntity userJpaEntity = new UserJpaEntity();
        userJpaEntity.setId(user.getId());
        userJpaEntity.setName(user.getName());
        userJpaEntity.setEmail(user.getEmail());
        return userJpaEntity;
    }

    public User toDomain(UserJpaEntity userJpaEntity) {
        return new User(userJpaEntity.getId(), userJpaEntity.getName(), userJpaEntity.getEmail());
    }
}
