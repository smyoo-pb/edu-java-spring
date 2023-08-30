package com.example.hexagonal.profiles.adapter.in.rest.response;

import java.util.List;

import com.example.hexagonal.profiles.domain.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class ProfileResponse {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String email;

    public static ProfileResponse fromDomain(Profile user) {
        return new ProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail());
    }

    public static List<ProfileResponse> fromDomain(List<Profile> users) {
        return users.stream().map(ProfileResponse::fromDomain).toList();
    }
}
