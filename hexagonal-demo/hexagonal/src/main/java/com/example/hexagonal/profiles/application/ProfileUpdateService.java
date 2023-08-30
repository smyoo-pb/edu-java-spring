package com.example.hexagonal.profiles.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal.profiles.application.exception.NotFoundProfileException;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileUpdateCommand;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileUpdateUseCase;
import com.example.hexagonal.profiles.application.port.out.ProfileReadPort;
import com.example.hexagonal.profiles.application.port.out.ProfileUpdatePort;
import com.example.hexagonal.profiles.domain.Profile;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@RequiredArgsConstructor
@Transactional
@Service
public class ProfileUpdateService implements ProfileUpdateUseCase {
    private final ProfileReadPort userReadPort;
    private final ProfileUpdatePort userUpdatePort;

    /**
     * Updates a profile based on the given profile update command.
     *
     * @param command the profile update command containing the necessary
     *                information
     * @return the updated profile
     */
    public Profile update(ProfileUpdateCommand command) {
        var exists = userReadPort.findById(command.getId());

        if (exists == null) {
            throw new NotFoundProfileException();
        }

        return userUpdatePort.update(new Profile(
                exists.getId(),
                command.getName(),
                exists.getEmail()));
    }
}
