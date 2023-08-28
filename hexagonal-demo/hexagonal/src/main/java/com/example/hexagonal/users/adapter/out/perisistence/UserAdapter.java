package com.example.hexagonal.users.adapter.out.perisistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.example.hexagonal.infrastructure.entities.UserJpaEntity;
import com.example.hexagonal.infrastructure.repositories.UserJpaRepository;
import com.example.hexagonal.users.application.port.out.UserCreatePort;
import com.example.hexagonal.users.application.port.out.UserDeletePort;
import com.example.hexagonal.users.application.port.out.UserReadPort;
import com.example.hexagonal.users.application.port.out.UserUpdatePort;
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
public class UserAdapter implements UserCreatePort, UserReadPort, UserUpdatePort, UserDeletePort {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User create(User user) {
        UserJpaEntity entity = userJpaRepository.save(userMapper.toJpaEntity(user));
        return userMapper.toDomain(entity);
    }

    @Override
    public User findById(Long id) {
        Optional<UserJpaEntity> entity = userJpaRepository.findById(id);
        if (entity == null || !entity.isPresent()) {
            return null;
        }

        return userMapper.toDomain(entity.get());
    }

    @Override
    public List<User> findAll() {
        return userMapper.toDomain(userJpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
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
