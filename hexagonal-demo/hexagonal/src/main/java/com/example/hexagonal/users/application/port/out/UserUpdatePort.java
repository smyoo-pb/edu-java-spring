package com.example.hexagonal.users.application.port.out;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface UserUpdatePort {
    User update(User command);
}
