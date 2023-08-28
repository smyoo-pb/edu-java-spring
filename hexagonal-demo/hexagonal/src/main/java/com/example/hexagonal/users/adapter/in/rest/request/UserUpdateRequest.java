package com.example.hexagonal.users.adapter.in.rest.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
@Value
public class UserUpdateRequest {
    @NotEmpty
    public String name;
}
