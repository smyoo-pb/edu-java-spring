package com.example.hexagonal.profiles.adapter.in.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Getter
@ToString
@NoArgsConstructor
public class ProfileUpdateRequest {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private int birth;

    @NotBlank
    private String gender;
}
