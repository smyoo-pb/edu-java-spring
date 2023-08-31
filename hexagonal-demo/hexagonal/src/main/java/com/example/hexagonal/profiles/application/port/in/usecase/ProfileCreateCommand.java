package com.example.hexagonal.profiles.application.port.in.usecase;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Value
@Builder
public class ProfileCreateCommand {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private int birth;
    @NotNull
    private String gender;
}
