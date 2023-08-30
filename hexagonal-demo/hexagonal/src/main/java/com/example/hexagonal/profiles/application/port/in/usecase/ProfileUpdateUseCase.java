package com.example.hexagonal.profiles.application.port.in.usecase;

import com.example.hexagonal.profiles.domain.Profile;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface ProfileUpdateUseCase {
    Profile update(ProfileUpdateCommand command);
}
