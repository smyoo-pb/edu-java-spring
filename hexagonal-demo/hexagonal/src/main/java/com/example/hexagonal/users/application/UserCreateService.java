package com.example.hexagonal.users.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.exceptions.AlreadyExistsUserException;
import com.example.hexagonal.users.application.port.in.UserCreateCommand;
import com.example.hexagonal.users.application.port.in.UserCreateUseCase;
import com.example.hexagonal.users.application.port.out.UserCreatePort;
import com.example.hexagonal.users.application.port.out.UserReadPort;
import com.example.hexagonal.users.application.port.out.UserTranslatePort;
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
@Service
public class UserCreateService implements UserCreateUseCase {
    private final UserCreatePort userCreatePort;
    private final UserReadPort userReadPort;
    private final UserTranslatePort translator;

    public User create(UserCreateCommand user) {
        if (userReadPort.existsByEmail(user.getEmail())) {
            throw new AlreadyExistsUserException(translator.translate("users.create.exists"));
        }

        return userCreatePort.create(new User(
                null,
                user.getName(),
                user.getEmail()));
    }
}
