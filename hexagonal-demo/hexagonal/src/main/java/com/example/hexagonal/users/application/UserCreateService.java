package com.example.hexagonal.users.application;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.port.in.UserCreateUseCase;
import com.example.hexagonal.users.application.port.out.UserCreatePort;
import com.example.hexagonal.users.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RequiredArgsConstructor
@Transactional
@Component
public class UserCreateService implements UserCreateUseCase {
    private final UserCreatePort userCreatePort;

    public User create(User user) {
        User exists = userCreatePort.findByEmail(user.getEmail());
        if (exists != null) {
            throw new AlreadyExistsUserException("User already exists");
        }

        return userCreatePort.create(new User(
                null,
                user.getName(),
                user.getEmail()));
    }
}
