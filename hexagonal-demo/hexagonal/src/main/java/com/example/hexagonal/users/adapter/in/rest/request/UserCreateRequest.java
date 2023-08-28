package com.example.hexagonal.users.adapter.in.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Value
public class UserCreateRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
}