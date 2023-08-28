package com.example.hexagonal.users.application.port.out;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface UserCreatePort {
    User create(User user);

    User findByEmail(String email);
}
