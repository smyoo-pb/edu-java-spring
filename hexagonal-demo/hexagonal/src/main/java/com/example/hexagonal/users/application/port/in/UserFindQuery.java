package com.example.hexagonal.users.application.port.in;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface UserFindQuery {
    User findById(Long id);
}
