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
@Builder
@Value
public class UserUpdateCommand {
    @NotNull
    private Long id;
    @NotNull
    private String name;
}
