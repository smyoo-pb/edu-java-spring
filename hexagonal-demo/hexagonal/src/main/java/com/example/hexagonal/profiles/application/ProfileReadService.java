package com.example.hexagonal.profiles.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hexagonal.profiles.application.exception.NotFoundProfileException;
import com.example.hexagonal.profiles.application.port.in.query.ProfileFindAllQuery;
import com.example.hexagonal.profiles.application.port.in.query.ProfileFindQuery;
import com.example.hexagonal.profiles.application.port.out.ProfileReadPort;
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
public class ProfileReadService implements ProfileFindAllQuery, ProfileFindQuery {
    private final ProfileReadPort userFindAllPort;

    /**
     * This function overrides the findAll() method in the parent class.
     *
     * @return a list of Profile objects
     */
    @Override
    public List<Profile> findAll() {
        return userFindAllPort.findAll();
    }

    /**
     * Retrieves a profile by its ID.
     *
     * @param id the ID of the profile to retrieve
     * @return the profile with the specified ID
     */
    @Override
    public Profile findById(Long id) {
        var user = userFindAllPort.findById(id);
        if (user == null) {
            throw new NotFoundProfileException();
        }

        return user;
    }

}
