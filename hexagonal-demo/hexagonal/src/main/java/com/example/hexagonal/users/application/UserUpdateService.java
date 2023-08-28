package com.example.hexagonal.users.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.exceptions.NotFoundUserException;
import com.example.hexagonal.users.application.port.in.usecase.UserUpdateCommand;
import com.example.hexagonal.users.application.port.in.usecase.UserUpdateUseCase;
import com.example.hexagonal.users.application.port.out.UserReadPort;
import com.example.hexagonal.users.application.port.out.UserUpdatePort;
import com.example.hexagonal.users.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@RequiredArgsConstructor
@Transactional
@Service
public class UserUpdateService implements UserUpdateUseCase {
    private final UserReadPort userReadPort;
    private final UserUpdatePort userUpdatePort;

    public User update(UserUpdateCommand command) {
        var exists = userReadPort.findById(command.getId());

        if (exists == null) {
            throw new NotFoundUserException();
        }

        return userUpdatePort.update(new User(
                exists.getId(),
                command.getName(),
                exists.getEmail()));
    }
}
