package com.example.hexagonal.users.application.port.in.query;

import java.util.List;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface UserFindAllQuery {
    List<User> findAll();
}
