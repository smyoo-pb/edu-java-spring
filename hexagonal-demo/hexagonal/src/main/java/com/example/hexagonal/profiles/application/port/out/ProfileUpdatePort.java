package com.example.hexagonal.profiles.application.port.out;

import com.example.hexagonal.profiles.domain.Profile;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface ProfileUpdatePort {
    Profile update(Profile command);
}
