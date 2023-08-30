package com.example.hexagonal.profiles.adapter.in.rest.request;

import java.time.LocalDate;

import com.example.hexagonal.profiles.application.port.in.usecase.ProfileCreateCommand;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Getter
@ToString
@NoArgsConstructor
public class ProfileCreateRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String species;
    private LocalDate birth;
    private String gender;
    private String nickname;
    private String breeds;

    public ProfileCreateCommand toCommand() {
        return ProfileCreateCommand.builder()
                .birth(birth)
                .name(name)
                .gender(gender)
                .nickname(nickname)
                .species(species)
                .breeds(breeds)
                .build();
    }
}