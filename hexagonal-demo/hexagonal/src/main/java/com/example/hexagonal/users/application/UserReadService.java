package com.example.hexagonal.users.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hexagonal.users.application.exceptions.NotFoundUserException;
import com.example.hexagonal.users.application.port.in.query.UserFindAllQuery;
import com.example.hexagonal.users.application.port.in.query.UserFindQuery;
import com.example.hexagonal.users.application.port.out.UserReadPort;
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
public class UserReadService implements UserFindAllQuery, UserFindQuery {
    private final UserReadPort userFindAllPort;

    @Override
    public List<User> findAll() {
        return userFindAllPort.findAll();
    }

    @Override
    public User findById(Long id) {
        var user = userFindAllPort.findById(id);
        if (user == null) {
            throw new NotFoundUserException();
        }

        return user;
    }

}
