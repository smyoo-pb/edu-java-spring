package com.example.hexagonal.profiles.application.port.in.usecase;

import com.example.hexagonal.profiles.domain.Profile;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface ProfileCreateUseCase {
    Profile create(ProfileCreateCommand command);
}
