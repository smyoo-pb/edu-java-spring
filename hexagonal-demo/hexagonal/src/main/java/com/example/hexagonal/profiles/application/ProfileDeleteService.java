package com.example.hexagonal.profiles.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal.profiles.application.exception.NotFoundProfileException;
import com.example.hexagonal.profiles.application.port.in.usecase.ProfileDeleteUseCase;
import com.example.hexagonal.profiles.application.port.out.ProfileDeletePort;
import com.example.hexagonal.profiles.application.port.out.ProfileReadPort;

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
public class ProfileDeleteService implements ProfileDeleteUseCase {
    private final ProfileReadPort userReadPort;
    private final ProfileDeletePort userDeletePort;

    /**
     * Delete a record by its ID.
     *
     * @param id the ID of the record to be deleted
     * @return nothing
     */
    @Override
    public void deleteById(Long id) {
        if (userReadPort.existsById(id)) {
            userDeletePort.deleteById(id);
        }

        throw new NotFoundProfileException();
    }
}
