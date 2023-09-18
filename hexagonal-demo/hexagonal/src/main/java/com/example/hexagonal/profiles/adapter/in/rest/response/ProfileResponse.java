package com.example.hexagonal.profiles.adapter.in.rest.response;

import java.time.LocalDateTime;
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
@Getter
public class ProfileResponse {
    private Long id;
    private String name;
    private String email;
    private int birth;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProfileResponse fromDomain(Profile user) {
        return new ProfileResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirth(),
                user.getGender(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }

    public static List<ProfileResponse> fromDomain(List<Profile> users) {
        return users.stream().map(ProfileResponse::fromDomain).toList();
    }
}
