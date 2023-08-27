package com.example.hexagonal.users.adapter.out.perisistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.hexagonal.infrastructure.entities.UserJpaEntity;
import com.example.hexagonal.infrastructure.repositories.UserJpaRepository;
import com.example.hexagonal.users.application.port.out.UserCreatePort;
import com.example.hexagonal.users.domain.User;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Component
@RequiredArgsConstructor
public class UserAdapter implements UserCreatePort {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User create(User user) {
        UserJpaEntity entity = userJpaRepository.save(userMapper.toJpaEntity(user));
        return userMapper.toDomain(entity);
    }

    @Override
    public User findByEmail(String email) {
        UserJpaEntity entity = userJpaRepository.findByEmail(email);
        if (entity == null) {
            return null;
        }
        return userMapper.toDomain(entity);
    }

}
