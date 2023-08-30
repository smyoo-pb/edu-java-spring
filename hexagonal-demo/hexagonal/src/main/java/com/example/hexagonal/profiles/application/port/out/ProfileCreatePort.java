package com.example.hexagonal.profiles.application.port.out;

import com.example.hexagonal.profiles.domain.Profile;

/**
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface ProfileCreatePort {
    Profile create(Profile user);
}
