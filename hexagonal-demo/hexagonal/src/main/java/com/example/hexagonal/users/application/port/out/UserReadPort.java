package com.example.hexagonal.users.application.port.out;

import java.util.List;

import com.example.hexagonal.users.domain.User;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface UserReadPort {
    User findById(Long id);

    List<User> findAll();

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
