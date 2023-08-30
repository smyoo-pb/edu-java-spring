package com.example.hexagonal.profiles.application.port.out;

import java.util.List;

import com.example.hexagonal.profiles.domain.Profile;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface ProfileReadPort {
    Profile findById(Long id);

    List<Profile> findAll();

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
