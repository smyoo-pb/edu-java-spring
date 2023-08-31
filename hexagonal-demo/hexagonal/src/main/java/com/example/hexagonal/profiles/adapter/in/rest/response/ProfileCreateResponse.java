package com.example.hexagonal.profiles.adapter.in.rest.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.hexagonal.profiles.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class ProfileCreateResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate birth;
    private String gender;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProfileCreateResponse fromDomain(Profile profile) {
        return new ProfileCreateResponse(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getBirth(),
                profile.getGender(),
                profile.getNickname(),
                profile.getCreatedAt(),
                profile.getUpdatedAt());
    }
}