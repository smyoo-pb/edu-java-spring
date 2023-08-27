package com.example.hexagonal.users.application.port.in;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface UserCreateUseCase {
    User create(User request);
}
