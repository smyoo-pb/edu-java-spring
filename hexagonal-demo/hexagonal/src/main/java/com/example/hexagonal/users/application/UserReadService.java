package com.example.hexagonal.users.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.exceptions.NotFoundUserException;
import com.example.hexagonal.users.application.port.in.UserFindAllQuery;
import com.example.hexagonal.users.application.port.in.UserFindQuery;
import com.example.hexagonal.users.application.port.out.UserReadPort;
import com.example.hexagonal.users.application.port.out.UserTranslatePort;
import com.example.hexagonal.users.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class UserReadService implements UserFindAllQuery, UserFindQuery {
    private final UserReadPort userFindAllPort;
    private final UserTranslatePort translator;

    @Override
    public List<User> findAll() {
        return userFindAllPort.findAll();
    }

    @Override
    public User findById(Long id) {
        var user = userFindAllPort.findById(id);
        if (user == null) {
            log.error("user is null");
            log.error(translator.translate("users.read.notFound"));
            throw new NotFoundUserException(translator.translate("users.read.notFound"));
        }

        return user;
    }

}
