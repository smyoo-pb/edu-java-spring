package com.example.hexagonal.profiles.application.port.in.query;

import java.util.List;

import com.example.hexagonal.profiles.domain.Profile;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public interface ProfileFindAllQuery {
    List<Profile> findAll();
}
