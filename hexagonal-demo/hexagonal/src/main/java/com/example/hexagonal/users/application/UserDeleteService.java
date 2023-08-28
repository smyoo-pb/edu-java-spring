package com.example.hexagonal.users.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.exceptions.NotFoundUserException;
import com.example.hexagonal.users.application.port.in.UserDeleteUseCase;
import com.example.hexagonal.users.application.port.out.UserDeletePort;
import com.example.hexagonal.users.application.port.out.UserReadPort;
import com.example.hexagonal.users.application.port.out.UserTranslatePort;

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
public class UserDeleteService implements UserDeleteUseCase {
    private final UserReadPort userReadPort;
    private final UserDeletePort userDeletePort;
    private final UserTranslatePort translator;

    @Override
    public void deleteById(Long id) {
        if (userReadPort.existsById(id)) {
            userDeletePort.deleteById(id);
        }

        throw new NotFoundUserException(translator.translate("users.read.notFound"));
    }
}
