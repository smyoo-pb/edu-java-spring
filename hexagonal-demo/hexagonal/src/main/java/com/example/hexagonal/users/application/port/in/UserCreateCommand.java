package com.example.hexagonal.users.application.port.in;

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
public class UserCreateCommand {
    @NotNull
    private final String name;
    @NotNull
    private final String email;
}
