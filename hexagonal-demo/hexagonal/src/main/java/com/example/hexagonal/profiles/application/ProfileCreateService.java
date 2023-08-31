package com.example.hexagonal.profiles.application;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.hexagonal.common.auth.port.AuthPort;
import com.example.hexagonal.profiles.application.exception.AlreadyExistsProfileException;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileCreateCommand;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileCreateUseCase;
import com.example.hexagonal.profiles.application.port.out.ProfileCreatePort;
import com.example.hexagonal.profiles.application.port.out.ProfileReadPort;
import com.example.hexagonal.profiles.domain.Profile;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RequiredArgsConstructor
@Transactional
@Service
public class ProfileCreateService implements ProfileCreateUseCase {
    private final AuthPort authPort;
    private final ProfileCreatePort profileCreatePort;
    private final ProfileReadPort profileReadPort;

    /**
     * Creates a new profile based on the provided profile creation command.
     *
     * @param user the profile creation command containing the user details
     * @return the created profile
     */
    public Profile create(ProfileCreateCommand profile) {

        if (profileReadPort.existsByEmail(profile.getEmail())) {
            throw new AlreadyExistsProfileException();
        }
        Profile profileDomain = new Profile(
                null,
                authPort.getId(),
                profile.getName(),
                profile.getBirth(),
                profile.getGender(),
                profile.getEmail(),
                profile.getNickname(),
                null,
                null,
                null);

        return profileCreatePort.create(profileDomain);
    }
}
